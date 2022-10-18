package com.addi.syndicat.services;

import com.addi.syndicat.entities.GestionnaireSite;
import com.addi.syndicat.entities.Site;
import com.addi.syndicat.payload.response.MessageResponse;
import com.addi.syndicat.repository.GestionnairesiteRepository;
import com.addi.syndicat.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionnaireSiteServiceImpl implements GestionnaireSiteService {
    @Autowired
    private GestionnairesiteRepository gestionnairesiteRepository;
    @Autowired
    private SiteRepository siteRepository;

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
            return ResponseEntity.badRequest().body(new MessageResponse("Le nom du gestionnaire du site est requis"));

        }
        if (gestionnaireSite.getSite().getCodeSite() == null || gestionnaireSite.getSite().getCodeSite().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Le Code du site est requis"));
        }
        if (gestionnaireSite.getFonction().isEmpty() ||gestionnaireSite.getFonction()==null ) {
            return ResponseEntity.badRequest().body(new MessageResponse("La fonction du gestionnaire du site  est requise"));
        }
        if (gestionnaireSite.getDateNomination()==null || gestionnaireSite.getDateDepart()==null ) {
            return ResponseEntity.badRequest().body(new MessageResponse("Date nomination/Date de depart sont requises"));
        }
        if (gestionnaireSite.getDateDepart().before(gestionnaireSite.getDateNomination()) ) {
            return ResponseEntity.badRequest().body(new MessageResponse("La date de nomination  doit être antérieur à la date de depart"));
        }
        if (gestionnaireSite.getTele()==null || gestionnaireSite.getTele().isEmpty() ) {
            return ResponseEntity.badRequest().body(new MessageResponse("le numéro de téléphone est requis"));
        }
            Site site=siteRepository.findByCodeSite(gestionnaireSite.getSite().getCodeSite());
            gestionnaireSite.setSite(site);
            gestionnairesiteRepository.save(gestionnaireSite);
             return ResponseEntity.ok(new MessageResponse("Gestionnaire du site est sauvegardé avec succès"));
    }

    @Override
    public GestionnaireSite updateGestionnairesite(GestionnaireSite gestionnairesite, long id) {
        gestionnairesite.setId(id);
        return gestionnairesiteRepository.save(gestionnairesite);

    }


}
