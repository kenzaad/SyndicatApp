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
    private String Adressesite;
    private String Ville;
    private String Titrefoncier;
    @Enumerated(EnumType.STRING)
    private BatimentsSite batimentssite;
    @OneToMany(mappedBy = "site")
    List<GestionnaireSite> gestionnairesites;
    @OneToMany(mappedBy = "site")
    List<Depenses>depenses;
    @ManyToOne
    private  Cession cession;
}
