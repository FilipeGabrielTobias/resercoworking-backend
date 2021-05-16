package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.dto.PaisDto;
import lombok.*;

import javax.persistence.*;

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
	
	@Column(name = "nome")
    private String nome;

	public Pais(PaisDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNmPais();

	}


	public Pais updatePais(PaisDto dto) {
        this.nome = dto.getNmPais();

        return this;

	}
}
