package com.projetosoftware2.resercoworking.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosoftware2.resercoworking.domain.FeedBackEspaco;
import com.projetosoftware2.resercoworking.dto.FeedBackEspacoDto;
import com.projetosoftware2.resercoworking.services.FeedBackService;
import com.projetosoftware2.resercoworking.services.ReservaEspacoService;

@RestController
@RequestMapping("/feedbackEspaco")
public class FeedBackResource {
   
	@Autowired
	private FeedBackService feedBackService;
	
	@Autowired
	private ReservaEspacoService reservaEspacoService;
	
	@PostMapping("/{idReserva}")
    public FeedBackEspaco saveFeedBack(@RequestBody FeedBackEspacoDto dto, @PathVariable Long idReserva) {
		FeedBackEspaco fe = feedBackService.saveFeedBackEspaco(dto);
		//adicionafeedback na reserva
        reservaEspacoService.adicionaFeedBack(fe.getId(), idReserva);
        return fe;
    }
}
