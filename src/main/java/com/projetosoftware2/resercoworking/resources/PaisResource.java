package com.projetosoftware2.resercoworking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.projetosoftware2.resercoworking.domain.Pais;
import com.projetosoftware2.resercoworking.dto.PaisDTO;
import com.projetosoftware2.resercoworking.services.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisResource {
	
	@Autowired
	private PaisService service;
	
	 @GetMapping
	 public List<Pais> getPais(){
         return service.getAll();    		  
	 }
	 
	 @GetMapping("/{id}")
	 public Pais getByIdPais(@PathVariable Long id) {
	        return service.getById(id);
	 }

	 @PostMapping
	 public Pais savePais(@RequestBody PaisDTO dto) {
	     return service.savePais(dto);
	 }

	 @PutMapping("/{PaisId}")
	 public Pais updatePais(@PathVariable Long PaisId, @RequestBody  PaisDTO dto) {
	      return service.updatePais(PaisId, dto);
	 }

	 @DeleteMapping("/{PaisId}")
	 public void deletePais(@PathVariable Long PaisId) {
	      service.deletePais(PaisId);
	 }
    
}
