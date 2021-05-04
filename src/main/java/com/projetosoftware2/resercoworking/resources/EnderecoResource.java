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
import com.projetosoftware2.resercoworking.domain.Endereco;
import com.projetosoftware2.resercoworking.dto.EnderecoDTO;
import com.projetosoftware2.resercoworking.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<Endereco> getEndereco(){
        return service.getAll();    		  
	}
	 
	@GetMapping("/{id}")
	public Endereco getByIdEndereco(@PathVariable Long id) {
	       return service.getById(id);
	}
	
	@PostMapping
	public Endereco saveEndereco(@RequestBody EnderecoDTO dto) {
	    return service.saveEndereco(dto);
	}

	@PutMapping("/{EnderecoId}")
	public Endereco updateEndereco(@PathVariable Long EnderecoId, @RequestBody  EnderecoDTO dto) {
	     return service.updateEndereco(EnderecoId, dto);
	}

	@DeleteMapping("/{EnderecoId}")
	public void deleteEndereco(@PathVariable Long EnderecoId) {
	     service.deleteEndereco(EnderecoId);
	}

}
