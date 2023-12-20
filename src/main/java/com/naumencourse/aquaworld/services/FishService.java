package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.FishDTO;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;

import java.util.List;
import java.util.UUID;

public interface FishService {

    FishDTO create(Fish fish) throws FishAlreadyExist;

    UUID deleteByName(String name) throws FishNotFoundException;

    List<FishDTO> getAllConfirmed() throws FishNotFoundException;

    List<FishDTO> getAllUnconfirmed() throws FishNotFoundException;

    FishDTO confirmFish(String name) throws FishNotFoundException;

    String deleteUnconfirmedFish(String name) throws FishNotFoundException;
}
