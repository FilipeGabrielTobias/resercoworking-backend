package com.projetosoftware2.resercoworking.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mensagem")
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "ds_mensagem", nullable = false, length = 255)
	private String dsMensagem;
	
	@Column(name = "dt_mensagem", nullable = false)
    private LocalDate dtMensagem;

}
