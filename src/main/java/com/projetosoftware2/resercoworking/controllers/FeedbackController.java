package com.projetosoftware2.resercoworking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;
import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;
import com.projetosoftware2.resercoworking.services.FeedbackService;
import com.projetosoftware2.resercoworking.services.ReservaEspacoService;

@RestController
@RequestMapping("/feedbackEspaco")
public class FeedbackController {
   
	@Autowired
	private FeedbackService feedBackService;
	
	@Autowired
	private ReservaEspacoService reservaEspacoService;
	
	@PostMapping("/{idReserva}")
    public FeedbackEspaco saveFeedBack(@RequestBody FeedbackEspacoDto dto, @PathVariable Long idReserva) {
		FeedbackEspaco fe = feedBackService.saveFeedBackEspaco(dto);
		//adicionafeedback na reserva
        reservaEspacoService.adicionaFeedBack(fe.getId(), idReserva);
        return fe;
    }
}
