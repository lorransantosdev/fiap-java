package org.example.controller;

import org.example.service.SoccerSystemService;

public class SoccerSystemController {

    private final SoccerSystemService service;

    public SoccerSystemController(SoccerSystemService service) { this.service = service; }

    public void start() {
        service.menu();
    }
}
