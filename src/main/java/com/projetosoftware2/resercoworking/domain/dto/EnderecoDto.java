package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.dto.BairroDto.Cidade;


import lombok.Data;

@Data
public class EnderecoDto {
  
	private Long id;
	private String nmRua;
	
	private Bairro bairro;
	
	@Data
    public static class Bairro{
		private Long id;
	    private String nmBairro;		
		private Cidade cidade;
	}
}

