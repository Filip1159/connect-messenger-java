--liquibase formatted sql
--changeset filip:3
create table conversation
(
    conversation_id BIGINT AUTO_INCREMENT PRIMARY KEY
)