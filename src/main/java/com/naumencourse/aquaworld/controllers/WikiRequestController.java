//package com.naumencourse.aquaworld.controllers;
//
//import com.naumencourse.aquaworld.constants.WebConstant;
////import com.naumencourse.aquaworld.dto.FishWikiRequestDTO;
//import com.naumencourse.aquaworld.entities.Fish;
//import com.naumencourse.aquaworld.exceptions.FishAlreadyExist;
////import com.naumencourse.aquaworld.repositories.FishWikiRequestRepository;
////import com.naumencourse.aquaworld.services.WikiRequestServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//import static org.springframework.http.ResponseEntity.status;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(WebConstant.VERSION_URL + "/wikirequest")
//public class WikiRequestController {
//
////    private final WikiRequestServiceImpl wikiRequestService;
//
//    @PostMapping(value = "/add/{author}"
//            , produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity createRequest(
//            @RequestBody Fish fish
//            , @PathVariable(name = "author") UUID aquaristId
//        ) {
//        try {
//            return status(HttpStatus.CREATED).body(wikiRequestService.createRequestToAddFish(fish, aquaristId));
//        } catch (FishAlreadyExist fishAlreadyExist) {
//            return status(HttpStatus.BAD_REQUEST).body(fishAlreadyExist.getMessage());
//        }catch (Exception e) {
//            return status(HttpStatus.BAD_REQUEST).body("Неизвестная ошибка добавления рыбки: "
//                    + fish.getName());
//        }
//    }
//
//}
