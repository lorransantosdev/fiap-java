package com.example.__toll_systems.repository.impl;

import com.example.__toll_systems.model.dto.Toll;
import com.example.__toll_systems.repository.TollSystemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TollSystemRepositoryImpl implements TollSystemRepository {

    private final List<Toll> tolls = new ArrayList<>();

    @Override
    public void saveTolls(List<Toll> tolls) {
        this.tolls.clear();
        this.tolls.addAll(tolls);
    }

}
