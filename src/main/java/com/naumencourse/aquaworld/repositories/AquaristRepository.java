package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Aquarist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AquaristRepository extends JpaRepository<Aquarist, UUID> {
    Optional<Aquarist> findByEmail(String email);

    Aquarist findAquaristByName(String aquaristName);

    Aquarist findAquaristById(UUID aquaristId);
}
