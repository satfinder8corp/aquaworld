package com.naumencourse.aquaworld.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FishWithConfirmFlagDTO {

    private UUID id;
    private String name;
    private Boolean isWaterSalty;
    private Boolean isFriendly;
    private Double minHP;
    private Double maxHP;
    private Integer minTemperature;
    private Integer maxTemperature;
    private Double minVolume;
    private Boolean isConfirm;

}
