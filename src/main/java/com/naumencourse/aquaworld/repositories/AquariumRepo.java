package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Aquarium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AquariumRepo extends JpaRepository<Aquarium, UUID> {

}
