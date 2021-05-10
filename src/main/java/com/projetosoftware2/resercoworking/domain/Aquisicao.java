package com.projetosoftware2.resercoworking.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.Endereco.EnderecoBuilder;

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
@Table(name = "aquisicao")
public class Aquisicao {
		    
    @Id
    @ManyToOne
    @JoinColumn(name = "Aquisição_fk0", nullable = false)
    private Premiacao premiacao;
    
    @Id
	@ManyToOne
    @JoinColumn(name = "Aquisição_fk1", nullable = false)
    private Usuario usuario;
    
    @Column(name = "dt_mensagem", nullable = false)
    private LocalDateTime dtMensagem;

}
