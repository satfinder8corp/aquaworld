package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.entities.ProposedFish;

import java.util.List;

public interface ProposedFishService {
    ProposedFish proposeNewFish(Fish fish);

    ProposedFish approveFish(Long proposedFishId);

    List<ProposedFish> getProposedFish();
}
