package com.naumencourse.aquaworld.mapper;

import com.naumencourse.aquaworld.dto.FishWikiRequestDTO;
import com.naumencourse.aquaworld.entities.FishWikiRequest;
import com.naumencourse.aquaworld.repositories.FishWikiRequestRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FishWikiRequestMapper {
    FishWikiRequestDTO fishWikiRequestToFishWikiRequestDTO(FishWikiRequest fishWikiRequest);
}
