package com.addi.syndicat.controllers;

import com.addi.syndicat.entities.Releves;
import com.addi.syndicat.services.RelevesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("Releves")
public class RelevesController {


    @Autowired
    private RelevesService relevesService;

    @GetMapping("/getReleves/{id}")
    public Releves getReleves(@PathVariable("id") Long id) {
        return relevesService.getReleves(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveReleves(@RequestBody Releves releves) {
        return relevesService.saveReleves(releves);
    }

    @GetMapping("/ListReleves")
    public List<Releves> listReleves() {
        return relevesService.listReleves();
    }

    @DeleteMapping("/deleteReleves/{id}")
    public int deleteReleves(@PathVariable("id") Long id) {
        return relevesService.deleteReleves(id);
    }

    @PutMapping("/Releves/{id}")
    public Releves updateReleves(@RequestBody Releves releves, @PathVariable("id") long id) {
        return relevesService.updateReleves(releves, id);
    }
}
