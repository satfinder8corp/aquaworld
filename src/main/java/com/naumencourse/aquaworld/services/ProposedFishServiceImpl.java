package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.entities.ProposedFish;
import com.naumencourse.aquaworld.repositories.ProposedFishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposedFishServiceImpl implements ProposedFishService{

    private final ProposedFishRepository proposedFishRepository;
    private final FishServiceImpl fishService;

    public ProposedFish proposeNewFish(Fish fish) {
        ProposedFish proposedFish = new ProposedFish();
        proposedFish.setFish(fish);
        proposedFish.setStatus(ProposedFish.FishStatus.PROPOSED);
        return proposedFishRepository.save(proposedFish);
    }

    public ProposedFish approveFish(Long proposedFishId) {
        ProposedFish proposedFish = proposedFishRepository.findById(proposedFishId).orElse(null);
        if (proposedFish != null) {
            proposedFish.setStatus(ProposedFish.FishStatus.APPROVED);
            return proposedFishRepository.save(proposedFish);
        }
        return null;
    }

    public List<ProposedFish> getProposedFish() {
        return proposedFishRepository.findAll();
    }
}
