package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proposed_fish")
public class ProposedFish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fish_id", nullable = false)
    private Fish fish;

    @Enumerated(EnumType.STRING)
    private FishStatus status;

    public enum FishStatus {
        PROPOSED, APPROVED, REJECTED
    }
}
