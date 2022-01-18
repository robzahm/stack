package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StackServiceTest {
    @InjectMocks
    private StackService stackService;


    @Test
    public void testPushGetPop() {
        stackService.push(1);
        stackService.push(2);
        assertEquals(1, stackService.get(0));
        assertEquals(2, stackService.get(1));

        assertEquals(2, stackService.pop());
        assertEquals(1, stackService.pop());

        Assertions.assertThrows(
                EmptyStackException.class, () -> {
            stackService.pop();
        });

        // Add out of bounds case

    }
}
