package org.example.controller;

import org.example.service.SoccerSystemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SoccerSystemControllerTest {

    @InjectMocks
    private SoccerSystemController controller;

    @Mock
    private SoccerSystemService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartShouldCallServiceMenu() {

        controller.start();
        verify(service, times(1)).menu();
        verifyNoMoreInteractions(service);
    }
}