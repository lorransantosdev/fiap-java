package org.example.controller;

import org.example.service.PeopleWithSpecialNeedsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PeopleWithSpecialNeedsControllerTest {

    @InjectMocks
    private PeopleWithSpecialNeedsController controller;

    @Mock
    private PeopleWithSpecialNeedsService service;

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