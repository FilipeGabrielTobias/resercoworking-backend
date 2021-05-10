package com.projetosoftware2.resercoworking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.services.ReservaEspacoService;
import com.projetosoftware2.resercoworking.services.UsuarioService;

@RestController
@RequestMapping("/reservaEspaco")
public class ReservaEspacoResources {
	
	@Autowired
	private ReservaEspacoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
    public List<ReservaEspaco> getReservas() {
        return service.getAllReservas();
    }

    @GetMapping("/{id}")
    public ReservaEspaco getByIdReservaEspaco(@PathVariable Long id) {
        return service.getReservaById(id);
    }

    @PostMapping
    public ReservaEspaco saveReservaEspaco(@RequestBody  ReservaEspacoDto dto) {
        return service.saveReserva(dto);
    }

    @PutMapping("/{ReservaId}")
    public ReservaEspaco finalizarReserva(@PathVariable Long ReservaId) {
        
    	return service.finalizarReserva(ReservaId);
        
    }
   
    
    public ReservaEspacoCancelamento cancelarReservaEspaco(@RequestBody  ReservaEspacoCancelamentoDto dto) {
    	 	
       return service.cancelarReservaEspaco(dto);
    }
    
	

}
