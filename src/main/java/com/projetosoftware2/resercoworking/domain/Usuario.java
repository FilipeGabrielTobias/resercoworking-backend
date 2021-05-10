package com.projetosoftware2.resercoworking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private Long id;
    
    @Column(name = "nr_cpf")
    private String cpf;
    
    @Column(name = "nm_usuario")
    private String nome;
        
    @ManyToOne
    @JoinColumn(name = "cd_endereco", nullable = false)
    private Endereco endereco;
    
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "nr_telefone")
    private Integer nrTelefone;

    @Column(name = "nm_email")
    private String email;
    
    @Column(name = "qt_pontos")
    private Integer qtPontos;
    
    @Column(name = "nm_login")
    private String nmLogin;
    
    @Column(name = "nm_senha")
    @JsonIgnore
    private String senha;
            
    @Column(name = "status_usuario")
    private Boolean situacao = Boolean.TRUE;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private Set<AssociacaoUsuarioPerfil> associacaoUsuarioPerfil = new HashSet<>();
}
