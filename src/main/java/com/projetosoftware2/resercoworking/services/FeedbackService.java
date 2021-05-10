package com.projetosoftware2.resercoworking.services;

import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;
import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;
import com.projetosoftware2.resercoworking.repositories.FeedbackEspacoRepository;



@Service
public class FeedbackService {
	
	FeedbackEspacoRepository feedBackEspacoRepository;
	
	public FeedbackEspaco saveFeedBackEspaco(FeedbackEspacoDto dto) {
		return feedBackEspacoRepository.save(new FeedbackEspaco(dto));
	}
	
	

}
