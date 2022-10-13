package com.addi.syndicat.services;

import com.addi.syndicat.entities.Depenses;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepensesService {
    Depenses getDepenses(String codedep);


    ResponseEntity<?> deleteDepense(Long id);

    List<Depenses> listDepenses();

    ResponseEntity<?> saveDepenses(Depenses depenses);

    ResponseEntity<?> updateDepenses(Depenses depenses, String code);
}
