package com.addi.syndicat.repository;

import com.addi.syndicat.entities.Releves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelevesRepository extends JpaRepository<Releves,Long> {
   Releves findByNumeroReleve(long numeroReleve);
}
