package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.AquaristDTO;
import com.naumencourse.aquaworld.dto.AquariumDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Aquarium;
import com.naumencourse.aquaworld.exceptions.AquaristAlreadyExist;
import com.naumencourse.aquaworld.mapper.AquaristMapper;
import com.naumencourse.aquaworld.mapper.AquariumMapper;
import com.naumencourse.aquaworld.repositories.AquaristRepository;
import com.naumencourse.aquaworld.repositories.AquariumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AquariumServiceImpl implements AquariumService {

    public final AquariumRepository aquariumRepository;
    public final AquaristRepository aquaristRepository;
    public final AquariumMapper aquariumMapper;


    public Aquarium save(Aquarium aquarium, UUID aquaristId) throws Exception {
        Optional<Aquarist> aquarist = aquaristRepository.findById(aquaristId) ;
        if (!aquarist.isPresent()) {
            throw new Exception("нет такого ID");
        }
        aquarium.setOwner(aquarist.get());
        return aquariumRepository.save(aquarium);
    }
}
