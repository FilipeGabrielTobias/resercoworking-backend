package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;

import lombok.Data;

@Data
public class FeedbackEspacoDto {

	
	private Long id;	
	private String dsFeedBack;
	private Integer notaFeedBack;
	
	public FeedbackEspacoDto(FeedbackEspaco feedBackEspaco) {
		this.id = feedBackEspaco.getId();
		this.dsFeedBack = feedBackEspaco.getDsfeedback();
		this.notaFeedBack = feedBackEspaco.getNotafeedback();
	}
	
	
	
}
