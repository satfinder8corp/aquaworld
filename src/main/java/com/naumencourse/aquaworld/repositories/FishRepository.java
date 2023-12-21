package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FishRepository extends JpaRepository<Fish, UUID> {
    List<Fish> findByIsConfirmFalse();

    List<Fish> findByIsConfirmTrue();
    Fish findFishByName(String name);

    Fish findFishById(UUID fishId);

    boolean existsByName(String name);
    void deleteByName(String name);
}
