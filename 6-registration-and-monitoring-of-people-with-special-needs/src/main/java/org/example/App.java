package org.example;

import org.example.controller.PeopleWithSpecialNeedsController;
import org.example.repository.Impl.PeopleWithSpecialNeedsRepositoryImpl;
import org.example.service.PeopleWithSpecialNeedsService;

public class App {
    private final PeopleWithSpecialNeedsController controller;

    public App(PeopleWithSpecialNeedsController controller) {
        this.controller = controller;
    }

    public void start() { controller.start(); }

    public static void main(String[] args) {

        PeopleWithSpecialNeedsController controller = new PeopleWithSpecialNeedsController(new PeopleWithSpecialNeedsService(new PeopleWithSpecialNeedsRepositoryImpl()));

        App app = new App(controller);
        app.start();
    }
}