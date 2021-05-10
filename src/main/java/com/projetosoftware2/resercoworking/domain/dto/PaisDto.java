package com.projetosoftware2.resercoworking.domain.dto;

import java.io.Serializable;

import com.projetosoftware2.resercoworking.domain.Pais;

import lombok.Data;

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
    	this.nmPais= pais.getNmPais();
    }   
    
}
