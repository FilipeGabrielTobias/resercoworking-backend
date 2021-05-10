package com.projetosoftware2.resercoworking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosoftware2.resercoworking.domain.Estado;
import com.projetosoftware2.resercoworking.domain.dto.EstadoDto;
import com.projetosoftware2.resercoworking.services.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public List<Estado> getEstado(){
        return service.getAll();    		  
	}
	 
	@GetMapping("/{id}")
	public Estado getByIdEstado(@PathVariable Long id) {
	       return service.getById(id);
	}

	@PostMapping
	public Estado saveEstado(@RequestBody EstadoDto dto) {
	    return service.saveEstado(dto);
	}

	@PutMapping("/{EstadoId}")
	public Estado updateEstado(@PathVariable Long EstadoId, @RequestBody EstadoDto dto) {
	     return service.updateEstado(EstadoId, dto);
	}

	@DeleteMapping("/{EstadoId}")
	public void deleteEstado(@PathVariable Long EstadoId) {
	     service.deleteEstado(EstadoId);
	}
}
