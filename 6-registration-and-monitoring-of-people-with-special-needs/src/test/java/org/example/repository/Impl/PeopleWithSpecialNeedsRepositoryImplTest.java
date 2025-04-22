package org.example.repository.Impl;

import org.example.model.Attendance;
import org.example.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PeopleWithSpecialNeedsRepositoryImplTest {

    @Spy
    private PeopleWithSpecialNeedsRepositoryImpl repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShouldSaveAndFindPerson() {
        Person person = new Person(0, "Maria", 25);
        repository.savePerson(person);

        Optional<Person> found = repository.findPersonById(person.getId());

        assertTrue(found.isPresent());
        assertEquals(person.getName(), found.get().getName());
        assertEquals(person.getAge(), found.get().getAge());
    }

    @Test
    void testShouldFindAllPersons() {
        Person p1 = new Person(0, "João", 30);
        Person p2 = new Person(1, "Ana", 22);

        repository.savePerson(p1);
        repository.savePerson(p2);

        List<Person> allPersons = repository.findAllPersons();

        assertEquals(2, allPersons.size());
        assertTrue(allPersons.contains(p1));
        assertTrue(allPersons.contains(p2));
    }

    @Test
    void testShouldSaveAndFindAttendances() {
        Person person = new Person(0, "Carlos", 40);
        repository.savePerson(person);

        Attendance att1 = new Attendance("Consulta médica");
        Attendance att2 = new Attendance("Terapia ocupacional");

        repository.saveAttendance(person.getId(), att1);
        repository.saveAttendance(person.getId(), att2);

        List<Attendance> attendances = repository.findAttendancesByPersonId(person.getId());

        assertEquals(2, attendances.size());
        assertTrue(attendances.contains(att1));
        assertTrue(attendances.contains(att2));
    }

    @Test
    void testShouldReturnEmptyAttendancesWhenNoneRegistered() {
        Person person = new Person(0, "Lucas", 28);
        repository.savePerson(person);

        List<Attendance> attendances = repository.findAttendancesByPersonId(person.getId());

        assertTrue(attendances.isEmpty());
    }

    @Test
    void testShouldReturnEmptyOptionalWhenPersonNotFound() {
        Optional<Person> found = repository.findPersonById(999);

        assertTrue(found.isEmpty());
    }

}