package com.javatraining.springchat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldLoginOnlyRegisteredUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"janek007\", \"password\": \"qwerty\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"ewa-nowak\", \"password\": \"abcd\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"mrsmith\", \"password\": \"hahaxd\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"grace01\", \"password\": \"pass01\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .content("{\"username\": \"bbbbb\", \"password\": \"aaaaa\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(401));
    }
}