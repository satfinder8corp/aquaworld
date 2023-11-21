package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aquariums")
public class Aquarium {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // объем аквариума в литрах
    private Integer volume;

    // соленая или пресная вода в аквариуме
    // true - соленая, false - пресная
    private Boolean isSaltWater;

    // список рыбок в аквариуме с кол-вом особей каждого вида
    @ElementCollection
    private Map<Fish, Integer> population = new HashMap<>();

    // владелец аквариума
    @ManyToOne
    @JoinColumn (name = "aquarist_id")
    private Aquarist owner;
}