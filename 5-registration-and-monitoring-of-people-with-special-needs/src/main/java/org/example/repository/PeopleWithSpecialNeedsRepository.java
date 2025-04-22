package org.example.repository;

import org.example.model.Attendance;
import org.example.model.Person;

import java.util.List;
import java.util.Optional;

public interface PeopleWithSpecialNeedsRepository {

    Person savePerson(Person p);
    List<Person> findAllPersons();
    Optional<Person> findPersonById(int id);

    void saveAttendance(int personId, Attendance att);
    List<Attendance> findAttendancesByPersonId(int personId);
}
