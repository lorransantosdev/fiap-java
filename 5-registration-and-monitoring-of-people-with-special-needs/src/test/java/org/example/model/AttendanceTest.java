package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceTest {
    @Test
    void testShouldCreateAttendanceWithDescriptionAndDate() {
        String description = "Sessão de fisioterapia";
        Attendance attendance = new Attendance(description);

        assertNotNull(attendance.getDate(), "Data não deveria ser nula");
        assertEquals(description, attendance.getDescription(), "Descrição deveria ser igual à passada no construtor");
    }

    @Test
    void testShouldGenerateProperToString() {
        String description = "Consulta médica";
        Attendance attendance = new Attendance(description);

        String toStringResult = attendance.toString();

        assertTrue(toStringResult.contains(description), "O toString deve conter a descrição");
        assertTrue(toStringResult.contains(attendance.getDate().toString()), "O toString deve conter a data");
    }
}