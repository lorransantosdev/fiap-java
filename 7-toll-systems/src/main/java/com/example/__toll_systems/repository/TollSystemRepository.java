package com.example.__toll_systems.repository;

import com.example.__toll_systems.model.dto.Toll;

import java.util.List;

public interface TollSystemRepository {
    void saveTolls(List<Toll> tolls);

}
