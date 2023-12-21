package com.naumencourse.aquaworld.controllers;

import com.naumencourse.aquaworld.constants.WebConstant;
import com.naumencourse.aquaworld.exceptions.AquaristNotFoundException;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;
import com.naumencourse.aquaworld.services.AquaristServiceImpl;
import com.naumencourse.aquaworld.services.FishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(WebConstant.VERSION_URL + "/admin")
public class AdminController {
    private final FishServiceImpl fishService;
    private final AquaristServiceImpl aquaristService;

    @GetMapping(value = "/fish",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUnconfirmFishes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fishService.getAllUnconfirmed());
        } catch (FishNotFoundException fishNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fishNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка отображения списка рыбок");
        }
    }

    @PutMapping("/fish/confirm/{fishId}")
    public ResponseEntity<?> confirmFish(@PathVariable UUID fishId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fishService.confirmFish(fishId));
        } catch (FishNotFoundException fishNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fishNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка отображения списка рыбок");
        }
    }

    @DeleteMapping(value = "/fish/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteFishByName(@PathVariable(name = "name") String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fishService.deleteByName(name));
        } catch (FishNotFoundException fishNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fishNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ошибка удаления рыбки: " + name);
        }
    }

    @DeleteMapping(value = "/aquarist/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAquaristById(@PathVariable(name = "id") UUID aquaristId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aquaristService.deleteAquaristById(aquaristId));
        } catch (AquaristNotFoundException aquaristNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(aquaristNotFoundException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ошибка удаления пользователя с id: " + aquaristId);
        }
    }
}
