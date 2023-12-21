package com.naumencourse.aquaworld.dto;

import com.naumencourse.aquaworld.entities.Fish;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FishDTO {

    private UUID id;
    private String name;
    private Boolean isWaterSalty;
    private Boolean isFriendly;
    private Double minHP;
    private Double maxHP;
    private Integer minTemperature;
    private Integer maxTemperature;
    private Double minVolume;

}
