package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.entities.Fish;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FishServiceImpl implements FishService{
// TODO:
//    private final FishDao fishDao;

    @Override
    public void create(Fish fish) {

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
    public void delete(Long fishId) {

    }

    @Override
    public List<Fish> getAll() {
        return null;
    }
}
