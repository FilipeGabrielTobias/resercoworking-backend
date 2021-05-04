package com.projetosoftware2.resercoworking.dto;

import java.io.Serializable;

import com.projetosoftware2.resercoworking.domain.Pais;

import lombok.Data;

@Data
public class PaisDTO implements Serializable {
   
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String nmPais;
    
    public PaisDTO(Pais pais) {
    	this.id = pais.getId();
    	this.nmPais= pais.getNmPais();
    }   
    
}
