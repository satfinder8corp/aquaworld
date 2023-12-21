package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.FishWikiRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FishWikiRequestRepository extends JpaRepository<FishWikiRequest, UUID> {

}
