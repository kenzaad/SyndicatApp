package com.addi.syndicat.entities;

import com.addi.syndicat.enums.BatimentsSite;
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
    private String codesite;
    private String Nomsite;
    private String adresseSite;
    private String ville;
    private String titreFoncier;
    @Enumerated(EnumType.STRING)
    private BatimentsSite batimentsSite;
    @OneToMany(mappedBy = "site")
    List<GestionnaireSite> gestionnaireSites;
    @OneToMany(mappedBy = "site")
    List<Depenses>depenses;
    @ManyToOne
    private  Cession cession;
}
