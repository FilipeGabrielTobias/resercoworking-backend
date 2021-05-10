package com.projetosoftware2.resercoworking.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspacoResumoDto {
    private Long id;
    private String nome;
    private Boolean situacao;
}
