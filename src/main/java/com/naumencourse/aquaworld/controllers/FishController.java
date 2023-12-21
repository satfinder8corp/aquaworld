package com.naumencourse.aquaworld.controllers;

import com.naumencourse.aquaworld.constants.WebConstant;
import com.naumencourse.aquaworld.entities.Fish;
import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
import com.naumencourse.aquaworld.exceptions.FishNotFoundException;
import com.naumencourse.aquaworld.services.FishServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(WebConstant.VERSION_URL + "/fish")
public class FishController {

    private final FishServiceImpl fishService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getConfirmFishes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fishService.getAllConfirmed());
        } catch (FishNotFoundException fishNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fishNotFoundException.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка отображения списка рыбок");
        }
    }



    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createFish(@RequestBody Fish fishToAdd) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(fishService.create(fishToAdd));
        } catch (FishAlreadyExist fishAlreadyExist) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(fishAlreadyExist.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Неизвестная ошибка добавления рыбки: " + fishToAdd.getName());
        }
    }
}
