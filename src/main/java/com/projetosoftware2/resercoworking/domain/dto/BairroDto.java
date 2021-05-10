package com.projetosoftware2.resercoworking.domain.dto;


import com.projetosoftware2.resercoworking.domain.dto.CidadeDto.Estado;


import lombok.Data;

@Data
public class BairroDto {

	private Long id;	
	
    private String nmBairro;
	
	private Cidade cidade;
	
	
	@Data
    public static class Cidade{
		private Long id;
	    private String nmCidade;		
		private Estado estado;
		
	}
}
