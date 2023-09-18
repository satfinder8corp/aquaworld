package com.naumencourse.aquaworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Fish {

    @Id
    @GeneratedValue
    UUID id;
    String name;
    Boolean isWaterSalty;
    Double maxTemp;
    Double minTemp;
    Double maxPH;
    Double minPH;
//    List<Fish> goodNeighbors;
}
