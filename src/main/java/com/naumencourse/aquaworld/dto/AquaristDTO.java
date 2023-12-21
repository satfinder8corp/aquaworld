package com.naumencourse.aquaworld.dto;

import com.naumencourse.aquaworld.entities.Aquarium;
import com.naumencourse.aquaworld.entities.FishWikiRequest;
import com.naumencourse.aquaworld.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
public class AquaristDTO {

    private UUID id;
    private String name;
    private String email;
    private LocalDateTime dateOfRegistry;
    private Set<Role> role = new HashSet<>();
    private List<Aquarium> aquariums;
//    private List<FishWikiRequest> requests;
}
