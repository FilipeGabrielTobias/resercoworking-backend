package com.projetosoftware2.resercoworking.domain;

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
@Table(name = "associacao_espaco_imagem")
public class AssociacaoEspacoImagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_espaco", nullable = false)
    private Espaco espaco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_arquivo", nullable = false)
    private Arquivo arquivo;
}
