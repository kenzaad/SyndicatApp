package com.addi.syndicat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class GestionnaireSite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeGestionnaire;
    private String nomGestionnaire;
    private String fonction;
    private int telefixe;
    private String gsm;
    private Date dateDepart;
    private Date dateNomination;
    @ManyToOne
    private Site site;
}
