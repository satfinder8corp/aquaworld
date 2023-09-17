package com.naumencourse.aquaworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fish")
public class Fish {
    @Id
    private Long fishId;

    private String fishName;

}
