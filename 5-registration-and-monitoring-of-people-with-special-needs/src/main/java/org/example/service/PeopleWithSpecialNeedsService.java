package org.example.service;

import org.example.model.Attendance;
import org.example.model.Person;
import org.example.repository.Impl.PeopleWithSpecialNeedsRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PeopleWithSpecialNeedsService {

    private final Scanner scanner = new Scanner(System.in);
    private final PeopleWithSpecialNeedsRepositoryImpl repository;

    public PeopleWithSpecialNeedsService(PeopleWithSpecialNeedsRepositoryImpl repository) {
        this.repository = repository;
    }

    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Sistema Simples de Cadastro ===");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Registrar atendimento");
            System.out.println("4. Ver atendimentos de pessoa");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            int opt = readInt();

            switch (opt) {
                case 1 -> registerPerson();
                case 2 -> listPersons();
                case 3 -> registerAttendance();
                case 4 -> listAttendances();
                case 5 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
        System.out.println("Encerrando...");
    }

    private void registerPerson() {
        System.out.print("Id: ");
        int id = readInt();
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Idade: ");
        int age = readInt();
        Person person = new Person(id, name, age);
        repository.savePerson(person);
        System.out.println("Pessoa cadastrada: " + person);
    }

    private void listPersons() {
        List<Person> persons = repository.findAllPersons();
        if (persons.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            persons.forEach(System.out::println);
        }
    }

    private void registerAttendance() {
        System.out.print("ID da pessoa: ");
        int id = readInt();
        Optional<Person> person = repository.findPersonById(id);
        if (person.isEmpty()) {
            System.out.println("Pessoa não encontrada.");
            return;
        }
        System.out.print("Descrição do atendimento: ");
        String desc = scanner.nextLine();
        Attendance attendance = new Attendance(desc);
        repository.saveAttendance(id, attendance);
        System.out.println("Atendimento registrado para " + person.get().getName());
    }

    private void listAttendances() {
        System.out.print("ID da pessoa: ");
        int id = readInt();
        List<Attendance> attendances = repository.findAttendancesByPersonId(id);
        if (attendances.isEmpty()) {
            System.out.println("Sem atendimentos para essa pessoa.");
        } else {
            attendances.forEach(System.out::println);
        }
    }

    private int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }
}

