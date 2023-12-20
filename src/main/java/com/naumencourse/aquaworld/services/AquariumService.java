package com.naumencourse.aquaworld.services;


import com.naumencourse.aquaworld.dto.AquariumDTO;
import com.naumencourse.aquaworld.entities.Aquarium;

import java.util.UUID;

public interface AquariumService {

    public Aquarium save(Aquarium aquarium, UUID aquaristId) throws Exception;
}
