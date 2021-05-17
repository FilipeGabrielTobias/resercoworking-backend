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
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "nome")
    private String nome;
        
    @ManyToOne
    @JoinColumn(name = "endereco", nullable = false)
    private Endereco endereco;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;
    
    @Column(name = "quantidade_pontos")
    private Integer quantidadePontos = 0;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;
            
    @Column(name = "situacao")
    private Boolean situacao = Boolean.TRUE;

    @JoinTable(name = "usuario_perfil")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Perfil> perfis = new HashSet<>();
}
