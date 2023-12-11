package com.naumencourse.aquaworld.controllers;

import com.naumencourse.aquaworld.constants.WebConstant;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Aquarium;
import com.naumencourse.aquaworld.services.AquariumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = WebConstant.VERSION_URL + "/aquarium")
public class AquariumController {

    private final AquariumServiceImpl aquariumServiceImpl;

    @PostMapping
    public ResponseEntity createAquarium(@RequestBody Aquarium aquarium, @RequestParam UUID aquaristID) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(aquariumServiceImpl.save(aquarium, aquaristID));
        } catch (Exception e) {
            System.out.println("Ошибка создания аквариума");
            return ResponseEntity.badRequest().body("Ошибка добавления аквариума");
        }
    }
}
