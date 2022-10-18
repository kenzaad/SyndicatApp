package com.addi.syndicat.entities;

import com.addi.syndicat.enums.BatimentsSite;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Site {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeSite;
    private String nomSite;
    private String adresseSite;
    private String ville;
    private String titreFoncier;
    @Enumerated(EnumType.STRING)
    private BatimentsSite batimentsSite;
    @OneToMany(mappedBy = "site")
    @JsonManagedReference
    List<GestionnaireSite> gestionnaireSites;
    @OneToMany(mappedBy = "site")
    List<Depenses>depenses;

}
