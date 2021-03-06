package com.projetosoftware2.resercoworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.CidadeDto;

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
@Table(name = "cidade")
public class Cidade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nome")
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado", nullable = false)
	private Estado estado;

	public Cidade(CidadeDto dto) {
		this.id = dto.getId();
		this.nome= dto.getNmCidade();
		Estado estado = new Estado();
		estado.setId(dto.getEstado().getId());
		this.estado = estado;
	}

	public Cidade updateCidade(CidadeDto dto) {
		this.nome= dto.getNmCidade();
		Estado estado = new Estado();
		estado.setId(dto.getEstado().getId());
		this.estado = estado;
		return this;
	}


}
