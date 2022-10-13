package com.addi.syndicat.services;

import com.addi.syndicat.entities.Depenses;
import com.addi.syndicat.payload.response.MessageResponse;
import com.addi.syndicat.repository.DepensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepensesServiceImpl implements DepensesService{
    @Autowired
    private DepensesRepository depensesRepository;

    @Override
    public Depenses getDepenses(String codedep) {
        return depensesRepository.findByCodeDep(codedep);
    }



    @Override
    public ResponseEntity<?> deleteDepense(Long id) {
         depensesRepository.deleteById(id);
       return ResponseEntity.ok(new MessageResponse("Dépense supprimée avec succès!"));
    }

    @Override
    public List<Depenses> listDepenses() {
        return depensesRepository.findAll();
    }

    @Override
    public ResponseEntity<?> saveDepenses(Depenses depenses) {

          depenses.setCodeDep(alphaNumeric.getAlphaNumericString(6));
           depensesRepository.save(depenses);

      return   ResponseEntity.ok(new MessageResponse("Dépense ajoutée avec succès!"));


    }

    @Override
    public ResponseEntity<?> updateDepenses(Depenses depenses,String code ){
        depenses.setCodeDep(code);
        return  ResponseEntity.ok(new MessageResponse("Dépense modifiée avec succès!"));


    }
}