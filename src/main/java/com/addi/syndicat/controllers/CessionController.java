package com.addi.syndicat.controllers;

import com.addi.syndicat.entities.Cession;
import com.addi.syndicat.services.CessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Cession")
@CrossOrigin(origins = "http://localhost:4200")

public class CessionController {


    @Autowired
    private CessionService cessionService;

    @GetMapping("/getCession/{codeCession}")
    public Cession getCession(@PathVariable("codeCession") String codeCession) {
        return cessionService.getCession(codeCession);
    }

    @DeleteMapping("/deleteCession/{id}")
    public ResponseEntity<?> deleteCession(@PathVariable("id") long id) {
        return cessionService.deleteCession(id);
    }

    @GetMapping("/ListCession")
    public List<Cession> listCessions() {

        return
        cessionService.listCessions();
    }
    @PostMapping("/")
    public ResponseEntity<?> saveCession(@RequestBody Cession cession) {
        return cessionService.saveCession(cession);
    }
    @PutMapping("/")
    public ResponseEntity<?> updateCession(@RequestBody Cession cession)  {
        return cessionService.updateCession(cession);
    }
}


