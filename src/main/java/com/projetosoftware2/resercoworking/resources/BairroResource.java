package com.projetosoftware2.resercoworking.resources;

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

import com.projetosoftware2.resercoworking.domain.Bairro;
import com.projetosoftware2.resercoworking.dto.BairroDTO;
import com.projetosoftware2.resercoworking.services.BairroService;

@RestController
@RequestMapping("/bairro")
public class BairroResource {
	
	@Autowired
	private BairroService service;
	
	@GetMapping
	public List<Bairro> getBairro(){
        return service.getAll();    		  
	}
	 
	@GetMapping("/{id}")
	public Bairro getByIdBairro(@PathVariable Long id) {
	       return service.getById(id);
	}

	@PostMapping
	public Bairro saveBairro(@RequestBody BairroDTO dto) {
	    return service.saveBairro(dto);
	}

	@PutMapping("/{BairroId}")
	public Bairro updateBairro(@PathVariable Long BairroId, @RequestBody  BairroDTO dto) {
	     return service.updateBairro(BairroId, dto);
	}

	@DeleteMapping("/{BairroId}")
	public void deleteBairro(@PathVariable Long BairroId) {
	     service.deleteBairro(BairroId);
	}
}
