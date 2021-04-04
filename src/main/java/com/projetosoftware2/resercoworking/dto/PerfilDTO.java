package com.projetosoftware2.resercoworking.dto;



import com.projetosoftware2.resercoworking.domain.Perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
public class PerfilDTO  {
	
	private Long id;	
	private String nome;
	private String descricao;
	
	
	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.nome = perfil.getNome();
		this.descricao = perfil.getDescricao();
	}
	
	
	public Perfil toEntity() {
		return Perfil.builder()
				.id(this.id)				
				.nome(this.nome)
				.descricao(this.descricao)
				.build();
	}

	
}
