package com.projetosoftware2.resercoworking.domain.dto;

import java.io.Serializable;

import com.projetosoftware2.resercoworking.domain.Pais;

import lombok.Data;

@Data
public class EstadoDto {
   
	private Long id;
	private String nmUF;
	private String nmEstado;
	private Pais pais;
	
	@Data
    public static class Pais{
		private Long id;
		private String nmPais;
	}
	
	
}
