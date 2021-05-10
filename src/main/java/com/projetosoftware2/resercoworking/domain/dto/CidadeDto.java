package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.dto.EstadoDto.Pais;

import lombok.Data;

@Data
public class CidadeDto {
    
    private Long id;
    
    private String nmCidade;
	
	private Estado estado;
	
	@Data
    public static class Estado{
		private Long id;
		private String nmUF;
		private String nmEstado;
		private Pais pais;
	}
}
