package com.naumencourse.aquaworld.mapper;

import com.naumencourse.aquaworld.dto.AquariumDTO;
import com.naumencourse.aquaworld.entities.Aquarium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AquariumMapper {

    public AquariumDTO aquariumToAquariumDTO(Aquarium aquarium);
}
