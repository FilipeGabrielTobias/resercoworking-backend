package com.projetosoftware2.resercoworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.PaisDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pais")
public class Pais {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nm_pais")
    private String nmPais;
	
	public Pais(PaisDto dto) {
		this.id = dto.getId();
		this.nmPais = dto.getNmPais();
		
	}
	
	
	public Pais updatePais(PaisDto dto) {
        this.nmPais = dto.getNmPais();
        
        return this;
		
	}
}
