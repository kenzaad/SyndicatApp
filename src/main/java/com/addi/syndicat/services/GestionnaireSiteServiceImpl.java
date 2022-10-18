package com.addi.syndicat.services;

import com.addi.syndicat.entities.GestionnaireSite;
import com.addi.syndicat.payload.response.MessageResponse;
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
    public ResponseEntity<?> saveGestionairesite(GestionnaireSite gestionnaireSite) {

        gestionnaireSite.setCodeGestionnaire(alphaNumeric.getAlphaNumericString(6));
        if (gestionnaireSite.getNomGestionnaire() == null || gestionnaireSite.getNomGestionnaire().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Nom du gestionnaire du site est requis"));

        }


    }

    @Override
    public GestionnaireSite updateGestionnairesite(GestionnaireSite gestionnairesite, long id) {
        gestionnairesite.setId(id);
        return gestionnairesiteRepository.save(gestionnairesite);

    }


}
