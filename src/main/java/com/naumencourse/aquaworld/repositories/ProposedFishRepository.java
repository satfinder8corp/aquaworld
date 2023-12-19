package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.ProposedFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposedFishRepository extends JpaRepository<ProposedFish,Long> {
}
