package com.projetosoftware2.resercoworking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.EnderecoDto;

import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nm_rua")
    private String nmRua;
	
	@ManyToOne
	@JoinColumn(name = "fk_bairro", nullable = false)
	private Bairro bairro;
	
	public Endereco(EnderecoDto dto) {
        this.id = dto.getId();
        this.nmRua = dto.getNmRua();
        Bairro bairro = new Bairro();
		bairro.setId(dto.getBairro().getId());
		this.bairro = bairro;
	}
	
	public Endereco updateEndereco(EnderecoDto dto) {
		this.nmRua = dto.getNmRua();
		Bairro bairro = new Bairro();
		bairro.setId(dto.getBairro().getId());
		this.bairro = bairro;
		return this;
	}

	
}
