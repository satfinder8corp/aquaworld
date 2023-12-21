package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fishes")
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    // название рыбки
    @Column(name = "name",unique = true)
    private String name;

    // маркер соленая вода или пресная нужна рыбе
    // true - соленая, false - пресная
    @Column(name = "salty_water")
    private Boolean isWaterSalty;

    // маркер дружелюбия рыбки
    // true - дружелюбная, false - нет
    @Column(name = "is_friendly")
    private Boolean isFriendly;

    // минимальная жесткость воды
    @Column(name = "min_HP")
    private Double minHP;

    // максимальная жесткость воды
    @Column(name = "max_HP")
    private Double maxHP;

    // минимальная температура воды
    @Column(name = "min_temperature")
    private Integer minTemperature;

    // максимальная температура воды
    @Column(name = "max_temperature")
    private Integer maxTemperature;

    // необходимый объем воды в литрах на одну рыбу данного вида
    @Column(name = "volume")
    private Double minVolume;

    // подтверждено ли администратором добавление в Wiki
    @Column(name = "state_of_confirm")
    private Boolean isConfirm;



//    // список аквариумов, в котором есть этот вид рыб
//    @ManyToMany
//    @JoinTable(
//            name = "fish_aquariums"
////            , joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "aquarium_id")
//            )
//    private List<Aquarium> aquariumList = new ArrayList<>();

//    // список запросов на изменение информации о рыбке
//    @OneToMany(
//            cascade = CascadeType.ALL, mappedBy = "fish")
//     private List<FishWikiRequest> changeInfoRequests;
}
