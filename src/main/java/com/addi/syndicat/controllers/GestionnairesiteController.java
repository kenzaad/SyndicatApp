package com.addi.syndicat.controllers;

import com.addi.syndicat.entities.GestionnaireSite;
import com.addi.syndicat.services.GestionnaireSiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestionnairesite")
public class GestionnairesiteController {
    @Autowired
    private GestionnaireSiteService gestionnairesiteService;

    @GetMapping("/getestionnairesite/{code}")
    public GestionnaireSite getGestionniresite(@PathVariable("code") String code) {
        return gestionnairesiteService.getGestionnairesite(code);
    }

    @DeleteMapping("/deleteGestionnairesite/{id}")
    public int deleteGestionnairesite(@PathVariable("id") long id) {
        return gestionnairesiteService.deleteGestionnairesite(id);
    }
    @GetMapping("/ListGestionairesite")
    public List<GestionnaireSite> listGestionnairesite() {

        return
                gestionnairesiteService.listGestionnairesite();
    }
    @PostMapping("/")
    public ResponseEntity<?> saveGestionnairesite(@RequestBody GestionnaireSite gestionnairesite) {
        return gestionnairesiteService.saveGestionairesite(gestionnairesite);
    }
    @PutMapping("/Gestionnairesite/{id}")
    public GestionnaireSite updategstionnaire(@RequestBody GestionnaireSite gestionnairesite, @PathVariable("id") long id)  {

        return gestionnairesiteService.updateGestionnairesite(gestionnairesite,id);
    }
}
