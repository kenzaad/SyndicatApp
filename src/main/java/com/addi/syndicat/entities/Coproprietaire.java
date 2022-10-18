package com.addi.syndicat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Coproprietaire {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY )
    private long id;
    private String codeCoproprietaire;
    private String nomCopro;
    private String cin;
    private String teleFixe;
    private  int gsm;
    private String email;
  @OneToOne(fetch = FetchType.EAGER,mappedBy ="coproprietaire",cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
@JsonIgnore
  Cession cessions;
  @OneToMany(mappedBy = "coproprietaire")
    List<Releves>releves;
;
}
