package com.projetosoftware2.resercoworking.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.*;
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
@Table(name = "recebimento")
public class Recebimento {
	
	@Id
	@ManyToOne
    @JoinColumn(name = "Recebimento_fk0", nullable = false)
    private Usuario usuario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "Recebimento_fk1", nullable = false)
    private Mensagem mensagem;
	

}
