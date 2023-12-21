package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Aquarium;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AquariumRepository extends CrudRepository<Aquarium, UUID> {
    List<Aquarium> findAllByOwner(Aquarist owner);
}
