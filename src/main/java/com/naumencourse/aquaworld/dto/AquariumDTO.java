package com.naumencourse.aquaworld.dto;

import com.naumencourse.aquaworld.entities.Fish;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Map;
import java.util.UUID;

public class AquariumDTO {

    private UUID id;
    private Integer volume;
    private Boolean isSaltWater;
    private Map<String, Integer> population;

}
