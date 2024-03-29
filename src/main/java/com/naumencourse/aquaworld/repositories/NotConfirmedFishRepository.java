package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public abstract class NotConfirmedFishRepository implements JpaRepository<Fish, UUID> {
}
