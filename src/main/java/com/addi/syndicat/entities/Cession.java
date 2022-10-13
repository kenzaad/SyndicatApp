package com.addi.syndicat.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeCession;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateAcquisition;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateVente;
    @OneToMany(mappedBy = "cession")
    private List<Site> sites;
    @OneToOne(fetch = FetchType.EAGER)

    private Coproprietaire coproprietaire;

}
