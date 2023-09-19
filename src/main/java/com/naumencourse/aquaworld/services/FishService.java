package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.entities.Fish;

import java.util.List;

public interface FishService {

    void create(Fish fish);

    Fish getById(Long fishId);

    Fish update(Fish fish);

    void delete(Long fishId);

    List<Fish> getAll();
}
