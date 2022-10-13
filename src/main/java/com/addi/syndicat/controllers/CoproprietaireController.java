package com.addi.syndicat.controllers;


import com.addi.syndicat.entities.Coproprietaire;
import com.addi.syndicat.services.CoproprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Coproprietaire")
@CrossOrigin(origins = "http://localhost:4200")
public class CoproprietaireController {


    @Autowired
    private CoproprietaireService coproprietaireService;

 @GetMapping("/getCoproprietaire/{codeCopro}")
    public Coproprietaire getCoproprietaire(@PathVariable("codeCopro") String codeCopro) {
        return coproprietaireService.getCoproprietaire(codeCopro);
    }

    @DeleteMapping("/deleteCoproprietaire/{id}")
    public ResponseEntity<?> deleteCoproprietaire(@PathVariable("id") long id) {
        return coproprietaireService.deleteCoproprietaire(id);
    }
@GetMapping("/ListCoprorietaire")
    public List<Coproprietaire> listCoproprietaires() {

     return coproprietaireService.listCoproprietaires();
    }
@PostMapping("/")
    public ResponseEntity<?> saveCopropriétaire(@RequestBody Coproprietaire coproprietaire) {
        return coproprietaireService.saveCopropriétaire(coproprietaire);
    }
@PutMapping("/")
    public ResponseEntity<?> updateCoproprietaire(@RequestBody Coproprietaire coproprietaire){

     return coproprietaireService.updateCoproprietaire(coproprietaire);
    }
}
