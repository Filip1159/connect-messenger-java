package com.example.connectmessenger.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_JPEG;
import static org.springframework.http.MediaType.IMAGE_PNG;
import static org.springframework.http.MediaType.IMAGE_GIF;

@Component
@RequiredArgsConstructor
public class AwsS3Client {
    private final AmazonS3 s3Client;

    public void putFile(String name, MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        if (!List.of(IMAGE_JPEG.getType(), IMAGE_PNG.getType(), IMAGE_GIF.getType()).contains(multipartFile.getContentType())) {
            throw new IllegalStateException("File must be an image");
        }

        var metadata = new ObjectMetadata();
        metadata.setContentType(multipartFile.getContentType());
        metadata.setContentLength(multipartFile.getSize());

        try {
            s3Client.putObject("connect-messenger", name, multipartFile.getInputStream(), metadata);
        } catch (IOException ignored) {
        }
    }

    public byte[] getFile(String fileName) {
        try {
            var s3Object = s3Client.getObject("connect-messenger", fileName);
            var inputStream = s3Object.getObjectContent();
            return IOUtils.toByteArray(inputStream);
        } catch (AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download file from s3", e);
        }
    }

}
