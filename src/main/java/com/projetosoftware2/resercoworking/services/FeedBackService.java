package com.projetosoftware2.resercoworking.services;

import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.FeedBackEspaco;
import com.projetosoftware2.resercoworking.dto.FeedBackEspacoDto;
import com.projetosoftware2.resercoworking.repositories.FeedBackEspacoRepository;



@Service
public class FeedBackService {
	
	FeedBackEspacoRepository feedBackEspacoRepository; 
	
	public FeedBackEspaco saveFeedBackEspaco(FeedBackEspacoDto dto) {
		return feedBackEspacoRepository.save(new FeedBackEspaco(dto));
	}
	
	

}
