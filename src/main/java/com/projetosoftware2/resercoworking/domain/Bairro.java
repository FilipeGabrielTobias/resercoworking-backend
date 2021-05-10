package com.projetosoftware2.resercoworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.BairroDto;

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
@Table(name = "bairro")
public class Bairro {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nm_bairro")
    private String nmBairro;
	
	@ManyToOne
	@JoinColumn(name = "fk_cidade", nullable = false)
	private Cidade cidade;
	
	public Bairro(BairroDto dto) {
		this.id = dto.getId();
		this.nmBairro = dto.getNmBairro();
		Cidade cidade = new Cidade();
		cidade.setId(dto.getCidade().getId());
		this.cidade = cidade;
	}

	public Bairro updateBairro(BairroDto dto) {
		this.nmBairro = dto.getNmBairro();
		Cidade cidade = new Cidade();
		cidade.setId(dto.getCidade().getId());
		this.cidade = cidade;		
		return this;
	}

	
}
