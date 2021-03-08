package com.projetosoftware2.resercoworking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String senha;

    @Column(name = "situacao")
    private Boolean situacao = Boolean.TRUE;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private Set<AssociacaoUsuarioPerfil> associacaoUsuarioPerfil = new HashSet<>();
}
