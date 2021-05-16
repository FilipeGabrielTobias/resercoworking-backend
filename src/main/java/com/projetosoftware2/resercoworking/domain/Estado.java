package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.dto.EstadoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
	
	@Column(name = "uf")
    private String uf;
	
	@Column(name = "nome")
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_pais", nullable = false)
	private Pais pais;


	public Estado(EstadoDto dto) {
		this.id = dto.getId();
		this.uf = dto.getNmUF();
		this.nome = dto.getNmEstado();
		Pais pais = new Pais();
		pais.setId(dto.getPais().getId());
		this.pais = pais;
	}

	public Estado updateEstado(EstadoDto dto) {
		this.uf = dto.getNmUF();
		this.nome = dto.getNmEstado();
		Pais pais =  new Pais();
		pais.setId(dto.getPais().getId());
		this.pais = pais;
		return this;
	}

}
