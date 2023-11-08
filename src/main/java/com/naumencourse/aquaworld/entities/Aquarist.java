package com.naumencourse.aquaworld.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "aquarists")
@Getter
@Setter
@NoArgsConstructor
public class Aquarist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID AquaristId;

    private String  username;

    @Column(unique = true)
    private String email;

    private String password;

    private Date dateOfRegistry;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "aquarist_role", joinColumns = @JoinColumn(name = "aquarist_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    private List<Aquarium> aquariums;
}
