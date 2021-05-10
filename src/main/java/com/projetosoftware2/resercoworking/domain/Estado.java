package com.projetosoftware2.resercoworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.EstadoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estado")
public class Estado {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nm_uf")
    private String nmUF;
	
	@Column(name = "nm_estado")
    private String nmEstado;
	
	@ManyToOne
	@JoinColumn(name = "fk_pais", nullable = false)
	private Pais pais;
	
	
	public Estado(EstadoDto dto) {
		this.id = dto.getId();
		this.nmUF = dto.getNmUF();
		this.nmEstado = dto.getNmEstado();
		Pais pais = new Pais();
		pais.setId(dto.getPais().getId());
		this.pais = pais;
	}
	
	public Estado updateEstado(EstadoDto dto) {
		this.nmUF = dto.getNmUF();
		this.nmEstado = dto.getNmEstado();
		Pais pais =  new Pais();
		pais.setId(dto.getPais().getId());
		this.pais = pais;		
		return this;
	}
	
}
