package com.addi.syndicat.repository;

import com.addi.syndicat.entities.GestionnaireSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnairesiteRepository extends JpaRepository<GestionnaireSite, Long> {
    GestionnaireSite findByCodeGestionnaire(String codeGestionnaire);

}
