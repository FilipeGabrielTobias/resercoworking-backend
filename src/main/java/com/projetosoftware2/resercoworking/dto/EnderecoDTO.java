package com.projetosoftware2.resercoworking.dto;

import com.projetosoftware2.resercoworking.dto.BairroDTO.Cidade;


import lombok.Data;

@Data
public class EnderecoDTO {
  
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

