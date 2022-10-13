package com.addi.syndicat.entities;

import com.addi.syndicat.enums.NatureDepenses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Depenses {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeDep;
    private Date dateDepense;
    private Date dateOperation;
    private int montant;
    private String nomFournisseur;
    @Enumerated(EnumType.STRING)
    private NatureDepenses natureDepense;
    @ManyToOne
    private Site site;
}
