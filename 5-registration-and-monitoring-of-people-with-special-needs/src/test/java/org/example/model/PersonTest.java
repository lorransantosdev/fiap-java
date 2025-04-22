package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testShouldCreatePersonWithGivenValues() {
        int id = 1;
        String name = "Ana";
        int age = 30;

        Person person = new Person(id, name, age);

        assertEquals(id, person.getId(), "ID deveria ser igual ao passado no construtor");
        assertEquals(name, person.getName(), "Nome deveria ser igual ao passado no construtor");
        assertEquals(age, person.getAge(), "Idade deveria ser igual ao passado no construtor");
    }

    @Test
    void testShouldGenerateProperToString() {
        Person person = new Person(2, "Bruno", 28);

        String expected = "[2] Bruno, 28 anos";
        String toStringResult = person.toString();

        assertEquals(expected, toStringResult, "O toString deve seguir o formato esperado");
    }
}