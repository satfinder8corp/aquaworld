package com.naumencourse.aquaworld.controllers;

import com.naumencourse.aquaworld.constants.WebConstant;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.exceptions.AquaristAlreadyExist;
import com.naumencourse.aquaworld.exceptions.AquaristNotFoundException;
import com.naumencourse.aquaworld.services.AquaristServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = WebConstant.VERSION_URL + "/aquarist"
//        , produces = MediaType.APPLICATION_JSON_VALUE
//        , consumes = MediaType.APPLICATION_JSON_VALUE
)
public class AquaristController {

    private final AquaristServiceImpl aquaristService;

    @PostMapping
    public ResponseEntity createAquarist(@RequestBody Aquarist aquarist) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(aquaristService.createAquarist(aquarist));
        } catch (AquaristAlreadyExist aquaristAlreadyExist) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(aquaristAlreadyExist.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ошибка добавления пользователя");
        }
    }

    @GetMapping
    public ResponseEntity getAquarists() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aquaristService.getAll());
        } catch (AquaristNotFoundException aquaristNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(aquaristNotFoundException);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ошибка отображения списка пользователя");
        }
    }
}
