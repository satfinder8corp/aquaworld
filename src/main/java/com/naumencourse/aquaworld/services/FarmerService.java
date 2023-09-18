package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.entities.Farmer;
import com.naumencourse.aquaworld.repositories.FarmerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FarmerService {

    private final FarmerRepo farmerRepo;

    public List<Farmer> findAll() {
        return farmerRepo.findAll();
    }

    public List<Farmer> findByEmailStartsWithIgnoreCase(String filterText) {
        return farmerRepo.findByEmailStartsWithIgnoreCase(filterText);
    }

    public void delete(Farmer farmer) {
        farmerRepo.delete(farmer);
    }

    public void save(Farmer farmer) {
        farmerRepo.save(farmer);
    }

    public List<Farmer> findById(UUID id) {
        return farmerRepo.findById(id).stream().toList();
    }
}
