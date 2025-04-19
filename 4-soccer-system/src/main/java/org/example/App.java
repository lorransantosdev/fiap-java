package org.example;

import org.example.controller.SoccerSystemController;
import org.example.repository.Impl.SoccerSystemRepositoryImpl;
import org.example.service.SoccerSystemService;

public class App {
    private final SoccerSystemController controller;

    public App(SoccerSystemController controller) { this.controller = controller; }

    public void start() { controller.start(); }

    public static void main(String[] args) {

        SoccerSystemController controller = new SoccerSystemController(new SoccerSystemService(new SoccerSystemRepositoryImpl()));

        App app = new App(controller);
        app.start();
    }

}