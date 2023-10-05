package com.naumencourse.aquaworld.repositories.fishDao;

import com.naumencourse.aquaworld.entities.Fish;

import java.util.List;

public interface FishDao {

    void create();

    List<Fish> getAll();

    Fish getById(Long id);

    void update(Long id, Fish fish);

    void deleteById(Long id);
}
