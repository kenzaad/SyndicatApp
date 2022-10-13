package com.addi.syndicat.services;

import com.addi.syndicat.entities.Releves;
import com.addi.syndicat.repository.RelevesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelevesServiceImpl implements RelevesService{
    @Autowired
    private RelevesRepository relevesRepository;

    @Override
    public Releves getReleves(Long numeroReleve) {
        return relevesRepository.findByNumeroReleve(numeroReleve);
    }

    @Override
    public ResponseEntity<String> saveReleves(Releves releves) {
        if(getReleves(releves.getNumeroReleve())!=null)
        {
            return  ResponseEntity.badRequest()
                    .body("Relevé existe déjà");
        }
        else
            relevesRepository.save(releves);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Relevé enregistré");

    }

    @Override
    public List<Releves> listReleves() {
        return relevesRepository.findAll();
    }

    @Override
    public int deleteReleves(Long id) {
        relevesRepository.deleteById(id);
        return 1;
    }

    @Override
    public Releves updateReleves(Releves releves, long id){
      releves.setId(id);
        return relevesRepository.save(releves);

    }

}
