package com.projetosoftware2.resercoworking.domain;

import lombok.*;

import javax.persistence.*;

import com.projetosoftware2.resercoworking.dto.PerfilDTO;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
    
    public Perfil(PerfilDTO perfilDTO) {
		this.id        = perfilDTO.getId();
		this.nome      = perfilDTO.getNome();
		this.descricao = perfilDTO.getDescricao();
	}

	public Perfil updatePerfil(PerfilDTO dto) {
		this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        

        return this;
		
	}
}
