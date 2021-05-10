package com.projetosoftware2.resercoworking.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModalidadeEspacoDto {

    private String nome;
    private String descricao;
    private Boolean situacao;
}
