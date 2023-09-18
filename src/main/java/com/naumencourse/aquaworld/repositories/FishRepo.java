package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FishRepo extends JpaRepository<Fish, UUID> {
}