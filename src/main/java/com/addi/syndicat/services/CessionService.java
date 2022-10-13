package com.addi.syndicat.services;

import com.addi.syndicat.entities.Cession;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CessionService {
    Cession getCession(String codeCession);
    ResponseEntity<?>  saveCession(Cession cession);
    List<Cession>  listCessions();
    ResponseEntity<?>  deleteCession(long id);
    ResponseEntity<?> updateCession(Cession cession);


}
