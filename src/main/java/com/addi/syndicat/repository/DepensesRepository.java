package com.addi.syndicat.repository;

import com.addi.syndicat.entities.Depenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepensesRepository extends JpaRepository<Depenses, Long> {
    Depenses findByCodeDep(String codedep);


}
