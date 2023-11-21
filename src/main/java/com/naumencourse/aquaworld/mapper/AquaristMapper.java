package com.naumencourse.aquaworld.mapper;

import com.naumencourse.aquaworld.dto.AquaristDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AquaristMapper {
    AquaristDTO aquarstToAquaristDTO(Aquarist aquarist);
}
