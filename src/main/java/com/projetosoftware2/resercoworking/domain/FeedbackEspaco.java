package com.projetosoftware2.resercoworking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;

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
@Table(name = "feedback_espaco") // confirmar nome com o grupo 
public class FeedbackEspaco implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "ds_feedback", length = 500)
    private String dsfeedback;
    
    @Column(name = "nota_feedback", nullable = false)
    private Integer notafeedback;

	public FeedbackEspaco(FeedbackEspacoDto dto) {
		this.id = dto.getId();
		this.dsfeedback = dto.getDsFeedBack();
		this.notafeedback = dto.getNotaFeedBack();
	}
       
    
}
