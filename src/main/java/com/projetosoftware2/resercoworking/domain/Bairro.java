package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.dto.BairroDto;
import lombok.*;

import javax.persistence.*;

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
	
	@Column(name = "nome")
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_cidade", nullable = false)
	private Cidade cidade;

	public Bairro(BairroDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNmBairro();
		Cidade cidade = new Cidade();
		cidade.setId(dto.getCidade().getId());
		this.cidade = cidade;
	}

	public Bairro updateBairro(BairroDto dto) {
		this.nome = dto.getNmBairro();
		Cidade cidade = new Cidade();
		cidade.setId(dto.getCidade().getId());
		this.cidade = cidade;
		return this;
	}


}
