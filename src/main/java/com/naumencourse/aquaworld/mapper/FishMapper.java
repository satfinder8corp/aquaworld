package com.naumencourse.aquaworld.mapper;

import com.naumencourse.aquaworld.dto.FishDTO;
import com.naumencourse.aquaworld.dto.FishWithConfirmFlagDTO;
import com.naumencourse.aquaworld.entities.Fish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FishMapper {

    FishDTO FishToFishDTO(Fish fish);

    FishWithConfirmFlagDTO FishToFishWithConfirmFlagDTO(Fish fish);

}
