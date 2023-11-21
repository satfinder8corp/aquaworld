package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.FishDTO;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;

import java.util.List;
import java.util.UUID;

public interface FishService {

    FishDTO create(Fish fish) throws FishAlreadyExist;

    Fish getById(Long fishId);

    Fish update(Fish fish);

    List<FishDTO> getAll() throws FishNotFoundException;

    public UUID deleteByName(String name) throws FishNotFoundException;

}
