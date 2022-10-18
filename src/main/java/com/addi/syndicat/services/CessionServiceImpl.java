package com.addi.syndicat.services;


import com.addi.syndicat.entities.Cession;
import com.addi.syndicat.entities.Coproprietaire;
import com.addi.syndicat.payload.response.MessageResponse;
import com.addi.syndicat.repository.CessionRepository;
import com.addi.syndicat.repository.CoproprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CessionServiceImpl implements CessionService {

    @Autowired
    private CessionRepository cessionRepository;
    @Autowired
    private CoproprietaireRepository coproprietaireRepository;

    @Override
    public Cession getCession(String codeCession) {

        return cessionRepository.findByCodeCession(codeCession);
    }

    @Override
    public ResponseEntity<?> saveCession(Cession cession) {
        cession.setCodeCession(alphaNumeric.getAlphaNumericString(6));
        if(cession.getCoproprietaire().getCodeCoproprietaire()==null || cession.getCoproprietaire().getCodeCoproprietaire().isEmpty())
        {
            return  ResponseEntity.badRequest().body(new MessageResponse(" Code du coproprietaire est requis"));
        }
        if(cession.getDateAcquisition()==null)
        {
            return  ResponseEntity.badRequest().body(new MessageResponse(" Date d'acquisition est requis"));
        }
        if(cession.getDateVente()==null)
        {
            return  ResponseEntity.badRequest().body(new MessageResponse(" Date de vente est requis"));
        }
        if(cession.getDateAcquisition().after(cession.getDateVente()))
        {
            return  ResponseEntity.badRequest().body(new MessageResponse(" Date de vente doit être antérieur à la date d'asquisition"));

        }
        Coproprietaire coproprietaire = coproprietaireRepository.findByCodeCoproprietaire(cession.getCoproprietaire().getCodeCoproprietaire());
        cession.setCoproprietaire(coproprietaire);
        cessionRepository.save(cession);
        return ResponseEntity.ok(new MessageResponse("Cession sauvegardé avec succès!"));


    }


    @Override
    public List<Cession> listCessions() {
        return cessionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteCession(long id) {

        cessionRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Cession Supprimé avec succès!"));

    }

    @Override
    public ResponseEntity<?> updateCession(Cession cession) {

        saveCession(cession);
        return ResponseEntity.ok(new MessageResponse("Cession modifié avec succès!"));

    }
}
