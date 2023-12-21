package com.naumencourse.aquaworld.entities;

//import com.naumencourse.aquaworld.mapper.FishWikiRequestMapperImpl;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "aquarists")
@Getter
@Setter
@NoArgsConstructor
public class Aquarist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // имя пользователя
    private String  name;

    // электронный почтовый адрес пользователя
    @Column(unique = true)
    private String email;

    // пароль пользователя
    private String password;

    // дата регистрации пользователя в системе
    private LocalDateTime dateOfRegistry;

     //набор ролей пользователя
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "aquarist_role", joinColumns = @JoinColumn(name = "aquarist_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role = new HashSet<>();

    // список аквариумов, созданных пользователем
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "owner"
    )
    private List<Aquarium> aquariums;

//    @OneToMany(mappedBy = "author")
//    private List<FishWikiRequest> requests;
}
