package com.addi.syndicat.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String tele;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateDepart;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateNomination;
    @ManyToOne
    @JsonBackReference

    private Site site;
}
