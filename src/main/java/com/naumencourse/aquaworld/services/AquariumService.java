package com.naumencourse.aquaworld.services;


import com.naumencourse.aquaworld.dto.AquariumDTO;
import com.naumencourse.aquaworld.entities.Aquarium;
import com.naumencourse.aquaworld.exceptions.AquariumNotFoundException;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;

import java.util.UUID;

public interface AquariumService {

    Aquarium save(Aquarium aquarium, UUID aquaristId) throws Exception;

    UUID delete(UUID aquariumId) throws AquariumNotFoundException;
}
