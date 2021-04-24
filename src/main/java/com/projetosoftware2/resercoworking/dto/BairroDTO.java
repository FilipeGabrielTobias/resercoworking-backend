package com.projetosoftware2.resercoworking.dto;


import com.projetosoftware2.resercoworking.domain.Cidade;
import com.projetosoftware2.resercoworking.dto.CidadeDTO.Estado;


import lombok.Data;

@Data
public class BairroDTO {

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
