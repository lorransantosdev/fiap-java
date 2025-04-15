package org.example.service;

import org.example.exception.InvalidInputException;
import org.example.repository.impl.ValueFormatterImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Locale;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;

class ValueFormatterServiceTest {

    @InjectMocks
    private ValueFormatterService service;

    @Mock
    private ValueFormatterImpl repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartProcessFormattingShouldReturnValidAmountWhenResultOk() {
        // Arrange
        when(repository.getAmountOfValues()).thenReturn(1);
        when(repository.getShowTypeLocale()).thenReturn(Locale.US);
        when(repository.getSeparatorType()).thenReturn('.');
        when(repository.getDecimalValues(Mockito.anyInt())).thenReturn(List.of(10.5));

        // Assert
        assertEquals(1, service.startProcessFormatting());
    }

    @Test
    void testStartProcessFormattingShouldReturnZeroWhenExceptionIsThrown() {
        when(repository.getAmountOfValues()).thenReturn(0);

        assertEquals(0, service.startProcessFormatting());
    }

    @Test
    void testProcessShouldReturnOneDecimalFormatWhenIsOk() {
        when(repository.getAmountOfValues()).thenReturn(1);
        when(repository.getShowTypeLocale()).thenReturn(Locale.US);
        when(repository.getSeparatorType()).thenReturn('.');
        when(repository.getDecimalValues(anyInt())).thenReturn(List.of(10.5));

        assertEquals(1, service.process());
    }

    @Test
    void testProcessShouldReturnTwoDecimalFormatWhenIsOk() {
        when(repository.getAmountOfValues()).thenReturn(2);
        when(repository.getShowTypeLocale()).thenReturn(Locale.US);
        when(repository.getSeparatorType()).thenReturn(',');
        when(repository.getDecimalValues(anyInt())).thenReturn(List.of(10.5, 100.58));

        assertEquals(2, service.process());
    }

    @Test
    void testvalidPlacesShouldSucessfullyWhenReturnOne() {

        when(repository.getAmountOfValues()).thenReturn(1);
        assertEquals(1, service.validPlaces());
    }

    @Test
    void testvalidPlacesShouldSucessfullyWhenReturnTwo() {
        when(repository.getAmountOfValues()).thenReturn(2);
        assertEquals(2, service.validPlaces());
    }

    @Test
    void testvalidPlacesShouldThrowNewExceptionWhenIsZero() {
        when(repository.getAmountOfValues()).thenReturn(0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validPlaces();
            });
        assertEquals("A quantidade deve ser maior que zero", exception.getMessage());
    }

    @Test
    void testvalidShowTypesShouldSucessfullyWhenReturnChar() {
        when(repository.getSeparatorType()).thenReturn(',');
        assertEquals(',', service.validShowTypes());
    }

    @Test
    void testvalidShowTypesShouldSucessfullyWhenReturnChar1() {
        when(repository.getSeparatorType()).thenReturn('.');
        assertEquals('.', service.validShowTypes());
    }

    @Test
    void testvalidShowTypesShouldThrowNewExceptionWhenCharNotEquals() {
        when(repository.getSeparatorType()).thenReturn('a');
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            service.validShowTypes();
        });
        assertEquals("Separador inválido! Use '.' ou ','.", exception.getMessage());
    }

}