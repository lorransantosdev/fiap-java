package org.example.controller;

import org.example.service.PeopleWithSpecialNeedsService;

public class PeopleWithSpecialNeedsController {

    private final PeopleWithSpecialNeedsService service;

    public PeopleWithSpecialNeedsController(PeopleWithSpecialNeedsService service) {
        this.service = service;
    }

    public void start() {
        service.menu();
    }
}
