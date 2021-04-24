package com.projetosoftware2.resercoworking.dto;



import com.projetosoftware2.resercoworking.domain.Estado;
import com.projetosoftware2.resercoworking.dto.EspacoDto.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.dto.EstadoDTO.Pais;

import lombok.Data;

@Data
public class CidadeDTO {
    
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
