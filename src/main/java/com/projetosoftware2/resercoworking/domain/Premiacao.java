package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.dto.PremiacaoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "premiacao")
public class Premiacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "pontos_necessarios", nullable = false)
    private Integer pontosNecessarios;

    @Column(name = "situacao", nullable = false)
    private Boolean situacao = Boolean.TRUE;

    public Premiacao(PremiacaoDto dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.pontosNecessarios = dto.getPontosNecessarios();
        this.situacao = dto.getSituacao();
    }

    public Premiacao updatePremiacao(PremiacaoDto dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.pontosNecessarios = dto.getPontosNecessarios();
        this.situacao = dto.getSituacao();

        return this;
    }
}
