package com.example.__toll_systems.controller;

import com.example.__toll_systems.model.TollSystemRequest;
import com.example.__toll_systems.model.response.TollSystemResponse;
import com.example.__toll_systems.service.TollSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toll")
public class TollSystemController {

    @Autowired
    private TollSystemService service;

    @PostMapping("/control-of-tolls")
    public ResponseEntity<TollSystemResponse> systemControlOfTolls(
            @RequestBody TollSystemRequest request) {

        return service.systemControlOfToll(request);
    }
}
