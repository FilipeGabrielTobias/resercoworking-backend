package com.projetosoftware2.resercoworking.dto;

import com.projetosoftware2.resercoworking.domain.FeedBackEspaco;

import lombok.Data;

@Data
public class FeedBackEspacoDto {

	
	private Long id;	
	private String dsFeedBack;
	private Integer notaFeedBack;
	
	public FeedBackEspacoDto(FeedBackEspaco feedBackEspaco) {		
		this.id = feedBackEspaco.getId();
		this.dsFeedBack = feedBackEspaco.getDsfeedback();
		this.notaFeedBack = feedBackEspaco.getNotafeedback();
	}
	
	
	
}
