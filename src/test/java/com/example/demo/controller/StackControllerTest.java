package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StackControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void testPushSuccess() throws Exception {


        mvc.perform(MockMvcRequestBuilders.post("/stack/push")
                .content("1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }
}
