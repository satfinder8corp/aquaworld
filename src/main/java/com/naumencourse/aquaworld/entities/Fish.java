package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fish")
public class Fish {

    @Id
    @Column(name = "id")
    private Long fishId;

    // наименование типа рыбы (неон, скалярия и т.п.)
    @Column(name = "name")
    private String fishName;

    // маркер соленая вода или пресная нужна рыбе
    // true - соленая, false - пресная
    @Column(name = "salty_water")
    private Boolean isWaterSalty;

    // маркер дружелюбия рыбки
    @Column(name = "is_friendly")
    private Boolean isFriendly;

    // минимальная жесткость воды
    @Column(name = "min_HP")
    private Integer minHP;

    // максимальная жесткость воды
    @Column(name = "max_HP")
    private Integer maxHP;

    // минимальная температура воды
    @Column(name = "min_temperature")
    private Integer minTemperature;

    // максимальная температура воды
    @Column(name = "max_temperature")
    private Integer maxTemperature;

    // необходимый объем воды в литрах на одну рыбу данного вида
    @Column(name = "volume")
    private Double minVolume;

    // список аквариумов, в котором есть этот вид рыб
    @ManyToMany
    @JoinTable(name = "fish_aquariums",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "aquariums_id"))
    private List<Aquarium> aquariumList = new java.util.ArrayList<>();
}
