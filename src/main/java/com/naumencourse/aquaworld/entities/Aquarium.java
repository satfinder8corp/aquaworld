package com.naumencourse.aquaworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Aquarium {

    @Id
    @GeneratedValue
    private UUID id;
//    Farmer owner;
    private Integer volume;
    private Boolean isHeater;
    private Boolean isFilter;
    private Boolean isOxygen;
    private Boolean isSaltWater;
//    Map<Fish, Integer> aqLivestock;

}
