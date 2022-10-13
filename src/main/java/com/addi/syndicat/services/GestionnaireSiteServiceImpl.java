package com.addi.syndicat.services;

import com.addi.syndicat.entities.GestionnaireSite;
import com.addi.syndicat.repository.GestionnairesiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionnaireSiteServiceImpl implements GestionnaireSiteService {
    @Autowired
    private GestionnairesiteRepository gestionnairesiteRepository;


    @Override
    public GestionnaireSite getGestionnairesite(String code) {
        return gestionnairesiteRepository.findByCodeGestionnaire(code);
    }

    @Override
    public int deleteGestionnairesite(long id) {
         gestionnairesiteRepository.deleteById(id);
         return 1;
    }

    @Override
    public List<GestionnaireSite> listGestionnairesite() {

        return gestionnairesiteRepository.findAll();
    }

    @Override
    public ResponseEntity<String> saveGestionairesite(GestionnaireSite gestionnairesite) {
        if ((getGestionnairesite(gestionnairesite.getCodeGestionnaire())) != null) {
            return ResponseEntity.badRequest()
                    .body("Gestionnaire site existe déjà");
        } else
            gestionnairesiteRepository.save(gestionnairesite);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Gestionnaire site enregistré");


    }

    @Override
    public GestionnaireSite updateGestionnairesite(GestionnaireSite gestionnairesite, long id) {
        gestionnairesite.setId(id);
        return gestionnairesiteRepository.save(gestionnairesite);

    }


}
