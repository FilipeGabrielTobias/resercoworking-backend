package com.projetosoftware2.resercoworking.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDto {
	private String nome;
	private String descricao;
	private boolean situacao;

}
