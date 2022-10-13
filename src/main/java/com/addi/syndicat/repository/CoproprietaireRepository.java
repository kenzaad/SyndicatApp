package com.addi.syndicat.repository;

import com.addi.syndicat.entities.Coproprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoproprietaireRepository extends JpaRepository<Coproprietaire, Long> {
    Coproprietaire findByCodeCoproprietaire(String codeCopro);


}
