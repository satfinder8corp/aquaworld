package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.FishDTO;
import com.naumencourse.aquaworld.dto.FishWikiRequestDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.entities.FishWikiRequest;
import com.naumencourse.aquaworld.exceptions.AquaristNotFoundException;
import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;
import com.naumencourse.aquaworld.mapper.AquaristMapper;
import com.naumencourse.aquaworld.mapper.FishMapper;
import com.naumencourse.aquaworld.mapper.FishWikiRequestMapper;
import com.naumencourse.aquaworld.repositories.AquaristRepository;
import com.naumencourse.aquaworld.repositories.AquariumRepository;
import com.naumencourse.aquaworld.repositories.FishRepository;
import com.naumencourse.aquaworld.repositories.FishWikiRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiRequestServiceImpl implements WikiRequestService {

    private final FishWikiRequestRepository fishWikiRequestRepository;
    private final FishWikiRequestMapper fishWikiRequestMapper;
    private final FishRepository fishRepository;
    private final AquaristRepository aquaristRepository;

    public FishWikiRequestDTO createRequestToAddFish(Fish fish, UUID aquaristId) throws Exception {
        if (fishRepository.findFishByName(fish.getName()) != null) {
            throw new FishAlreadyExist("Рыбка уже существует в Wiki");
        }
        Aquarist author = aquaristRepository.findById(aquaristId).orElse(null);
        if (author == null) {
            throw new AquaristNotFoundException("Пользователь не найден");
        }
        FishWikiRequest fishWikiRequest = new FishWikiRequest();
        fishWikiRequest.setFishId(fish.getId());
        fishWikiRequest.setAuthorId(author.getId());
        fishWikiRequest.setRequestDate(LocalDateTime.now());
        fishWikiRequest.setConfirmDate(null);
        fishWikiRequest.setIsConfirm(false);

//        fish.setIsConfirm(false);
//        fishRepository.save(fish);

        return fishWikiRequestMapper
                .fishWikiRequestToFishWikiRequestDTO(
                        fishWikiRequestRepository.save(fishWikiRequest)
                );
    }
}
