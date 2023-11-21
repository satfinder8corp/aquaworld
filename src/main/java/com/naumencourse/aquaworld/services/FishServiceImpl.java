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
            throw new FishAlreadyExist("Рыбка " + fish.getName() + " уже есть в Wiki");
        }
        return fishMapper.FishToFishDTO(fishRepository.save(fish));
    }

    @Override
    public Fish getById(Long fishId) {
        return null;
    }

    @Override
    public Fish update(Fish fish) {
        return null;
    }

    @Override
    public UUID deleteByName(String name) throws FishNotFoundException {
        Fish fish = fishRepository.findFishByName(name);
        if (fish == null) {
            throw new FishNotFoundException("Рыбка по имени " + name + " не найдена в Wiki");
        }
        fishRepository.delete(fish);
        return fish.getId();
    }

    @Override
    public List<FishDTO> getAll() throws FishNotFoundException {
        List<Fish> fishList = fishRepository.findAll();
        if (fishList.isEmpty()) {
            throw new FishNotFoundException("Wiki пуста - рыбок нет");
        }
        return fishList.stream().map(fishMapper::FishToFishDTO).toList();
    }

}
