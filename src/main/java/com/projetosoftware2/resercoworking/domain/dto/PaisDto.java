package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.Pais;
import lombok.Data;

import java.io.Serializable;

@Data
public class PaisDto implements Serializable {
   
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String nmPais;
    
    public PaisDto(Pais pais) {
    	this.id = pais.getId();
    	this.nmPais= pais.getNome();
    }   
    
}
