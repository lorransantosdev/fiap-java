package org.example.repository.Impl;

import org.example.model.Attendance;
import org.example.model.Person;
import org.example.repository.PeopleWithSpecialNeedsRepository;

import java.util.*;

public class PeopleWithSpecialNeedsRepositoryImpl implements PeopleWithSpecialNeedsRepository {

    private final Map<Integer, Person> personStore = new HashMap<>();
    private final Map<Integer, List<Attendance>> attendanceStore = new HashMap<>();

    @Override
    public Person savePerson(Person person) {
        personStore.put(person.getId(), person);
        return person;
    }

    @Override
    public List<Person> findAllPersons() {
        return new ArrayList<>(personStore.values());
    }

    @Override
    public Optional<Person> findPersonById(int id) {
        return Optional.ofNullable(personStore.get(id));
    }

    @Override
    public void saveAttendance(int personId, Attendance attendance) {
        attendanceStore.computeIfAbsent(personId, k -> new ArrayList<>()).add(attendance);
    }

    @Override
    public List<Attendance> findAttendancesByPersonId(int personId) {
        return attendanceStore.getOrDefault(personId, Collections.emptyList());
    }
}
