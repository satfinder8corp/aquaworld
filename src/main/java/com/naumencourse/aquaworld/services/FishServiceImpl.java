package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.FishDTO;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;
import com.naumencourse.aquaworld.mapper.FishMapper;
import com.naumencourse.aquaworld.repositories.FishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;
    private final FishMapper fishMapper;


    @Override
    public FishDTO create(Fish fish) throws FishAlreadyExist {
        if (fishRepository.findFishByName(fish.getName()) != null) {
            throw new FishAlreadyExist("Рыбка " + fish.getName() + " уже есть в Wiki.");
        }
        return fishMapper.FishToFishDTO(fishRepository.save(fish));
    }

    @Override
    public UUID deleteByName(String name) throws FishNotFoundException {
        Fish fish = fishRepository.findFishByName(name);
        if (fish == null) {
            throw new FishNotFoundException("Рыбка по имени " + name + " не найдена.");
        }
        fishRepository.delete(fish);
        return fish.getId();
    }

    @Override
    public List<FishDTO> getAllConfirmed() throws FishNotFoundException {
        List<Fish> fishList = fishRepository.findByIsConfirmTrue();
        if (fishList.isEmpty()) {
            throw new FishNotFoundException("Рыбок нет.");
        }
        return fishList.stream().map(fishMapper::FishToFishDTO).toList();
    }

    @Override
    public List<FishDTO> getAllUnconfirmed() throws FishNotFoundException {
        List<Fish> fishList = fishRepository.findByIsConfirmTrue();
        if (fishList.isEmpty()) {
            throw new FishNotFoundException("Рыбок, ожидающих подтверждение, не найдено.");
        }
        return fishList.stream().map(fishMapper::FishToFishDTO).toList();
    }
    @Override
    public FishDTO confirmFish(String name) throws FishNotFoundException {
        Fish fish = fishRepository.findFishByName(name);
        if (fish == null) {
            throw new FishNotFoundException("Рыбок, ожидающих подтверждение, не найдено.");
        }
        fish.setIsConfirm(true);
        return fishMapper.FishToFishDTO(fishRepository.save(fish));
    }
    @Override
    public String deleteUnconfirmedFish(String name) throws FishNotFoundException {

        if (fishRepository.existsByName(name)) {
            fishRepository.deleteByName(name);
            return name;
        }
        throw new FishNotFoundException("Рыбка c именем" + name + " не найдена.");
    }
}
