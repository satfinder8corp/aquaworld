//package com.naumencourse.aquaworld.controllers;
//
//import com.naumencourse.aquaworld.entities.Fish;
//import com.naumencourse.aquaworld.services.FishService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class FishController {
//
//    private final FishService fishService;
//
//    @PostMapping(value = "/fish/add")
//    public String create(Fish fish) {
//        fishService.create(fish);
//        return "redirect:/fish";
//    }
//
//    @PostMapping(value = "/fish/{id}")
//    public String delete(@PathVariable(name = "id") Long id) {
//        fishService.delete(id);
//        return "redirect:/fish";
//    }
//}
