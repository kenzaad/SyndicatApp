package com.addi.syndicat.services;

import com.addi.syndicat.entities.Coproprietaire;
import com.addi.syndicat.payload.response.MessageResponse;
import com.addi.syndicat.repository.CoproprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoproprietaireServiceImpl implements CoproprietaireService {
    @Autowired
    private CoproprietaireRepository coproprietaireRepository;


    @Override
    public Coproprietaire getCoproprietaire(String codeCopro) {

        return coproprietaireRepository.findByCodeCoproprietaire(codeCopro);
    }


    @Override
    @Transactional
    public ResponseEntity<?> deleteCoproprietaire(long id) {

        coproprietaireRepository.deleteById(id);
        return  ResponseEntity.ok(new MessageResponse("Copropriétaire supprimé avec succès!"));
    }

    @Override
    public List<Coproprietaire> listCoproprietaires() {
        return coproprietaireRepository.findAll();

    }

    @Override
    public ResponseEntity<?> saveCopropriétaire(Coproprietaire coproprietaire) {
        coproprietaire.setCodeCoproprietaire(alphaNumeric.getAlphaNumericString(6));
        coproprietaireRepository.save(coproprietaire);

        return  ResponseEntity.ok(new MessageResponse("Copropriétaire sauvegardé avec succès!"));


    }

    @Override
    public ResponseEntity<?>  updateCoproprietaire(Coproprietaire coproprietaire) {
        coproprietaireRepository.save(coproprietaire);
        return  ResponseEntity.ok(new MessageResponse("Copropriétaire modifié avec succès!"));


    }

}
