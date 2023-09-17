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

    @Column(name = "name")
    private String fishName;

    @Column(name = "salty_water")
    private Boolean isWaterSalty;

    @Column(name = "min_HP")
    private Integer minHP;

    @Column(name = "max_HP")
    private Integer maxHP;

    @Column(name = "min_temperature")
    private Integer minTemperature;

    @Column(name = "max_temperature")
    private Integer maxTemperature;

    @ManyToMany
    @JoinTable(name = "fish_aquariums",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "aquariums_id"))
    private List<Aquarium> aquariumList = new java.util.ArrayList<>();
}
