package com.addi.syndicat.services;


import com.addi.syndicat.entities.Coproprietaire;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoproprietaireService {
    Coproprietaire getCoproprietaire(String codeCopro);
    ResponseEntity<?> deleteCoproprietaire(long id);
    List<Coproprietaire> listCoproprietaires();
    ResponseEntity<?> saveCopropriétaire(Coproprietaire coproprietaire);
    ResponseEntity<?>  updateCoproprietaire(Coproprietaire coproprietaire);



}
