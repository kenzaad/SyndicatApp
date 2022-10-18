package com.addi.syndicat.services;

import com.addi.syndicat.entities.GestionnaireSite;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GestionnaireSiteService {
    GestionnaireSite getGestionnairesite(String code);
    int deleteGestionnairesite(long id);
    List<GestionnaireSite> listGestionnairesite();
    ResponseEntity<?> saveGestionairesite(GestionnaireSite gestionnairesite);
    GestionnaireSite updateGestionnairesite(GestionnaireSite gestionnairesite, long id);
}
