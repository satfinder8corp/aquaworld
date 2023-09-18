package com.naumencourse.aquaworld.repositories;

import com.naumencourse.aquaworld.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FarmerRepo extends JpaRepository<Farmer, UUID> {

    List<Farmer> findByEmailStartsWithIgnoreCase(String filterText);
}
