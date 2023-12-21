package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.AquaristDTO;
import com.naumencourse.aquaworld.dto.AquariumDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Aquarium;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.exceptions.AquaristAlreadyExist;
import com.naumencourse.aquaworld.exceptions.AquariumNotFoundException;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;
import com.naumencourse.aquaworld.mapper.AquaristMapper;
import com.naumencourse.aquaworld.mapper.AquariumMapper;
import com.naumencourse.aquaworld.repositories.AquaristRepository;
import com.naumencourse.aquaworld.repositories.AquariumRepository;
import com.naumencourse.aquaworld.repositories.FishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AquariumServiceImpl implements AquariumService {

    public final AquariumRepository aquariumRepository;
    public final AquaristRepository aquaristRepository;
    public final FishRepository fishRepository;
    public final AquariumMapper aquariumMapper;


    public Aquarium save(Aquarium aquarium, UUID aquaristId) throws Exception {
        Optional<Aquarist> aquarist = aquaristRepository.findById(aquaristId);
        if (!aquarist.isPresent()) {
            throw new Exception("нет такого ID");
        }
        aquarium.setOwner(aquarist.get());
        return aquariumRepository.save(aquarium);
    }

    public UUID delete(UUID aquariumId) throws AquariumNotFoundException {
        if (aquariumRepository.existsById(aquariumId)) {
            aquariumRepository.deleteById(aquariumId);
            return aquariumId;
        }
        throw new AquariumNotFoundException("Аквариум c ID " + aquariumId + " не найден.");
    }

    public Aquarium updatePopulation(UUID aquariumId, UUID fishId, Integer fishCount) throws AquariumNotFoundException, FishNotFoundException {
        Aquarium aquarium = aquariumRepository.findById(aquariumId).orElseThrow(
                () -> new AquariumNotFoundException("Аквариум c ID " + aquariumId + " не найден."));
        Fish fish = fishRepository.findById(fishId).orElseThrow(
                () -> new FishNotFoundException("Рыбка c ID " + fishId + " не доступна"));

        aquarium.getPopulation().put(fish.getName(), fishCount);
        aquariumRepository.save(aquarium);
        return aquarium;
    }

}
