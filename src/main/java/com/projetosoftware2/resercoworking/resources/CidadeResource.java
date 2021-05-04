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

import com.projetosoftware2.resercoworking.domain.Cidade;
import com.projetosoftware2.resercoworking.dto.CidadeDTO;
import com.projetosoftware2.resercoworking.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
   
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public List<Cidade> getCidade(){
        return service.getAll();    		  
	}
	 
	@GetMapping("/{id}")
	public Cidade getByIdCidade(@PathVariable Long id) {
	       return service.getById(id);
	}

	@PostMapping
	public Cidade saveCidade(@RequestBody CidadeDTO dto) {
	    return service.saveCidade(dto);
	}

	@PutMapping("/{CidadeId}")
	public Cidade updateCidade(@PathVariable Long CidadeId, @RequestBody  CidadeDTO dto) {
	     return service.updateCidade(CidadeId, dto);
	}

	@DeleteMapping("/{CidadeId}")
	public void deleteCidade(@PathVariable Long CidadeId) {
	     service.deleteCidade(CidadeId);
	}
}
