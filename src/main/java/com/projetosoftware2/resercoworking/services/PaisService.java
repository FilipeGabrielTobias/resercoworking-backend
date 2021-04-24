package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Pais;
import com.projetosoftware2.resercoworking.dto.PaisDTO;
import com.projetosoftware2.resercoworking.dto.PerfilDTO;
import com.projetosoftware2.resercoworking.repositories.PaisRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class PaisService {
 
	@Autowired
	private PaisRepository repository;
	
	public List<Pais> getAll() {
		return repository.findAll();
	}

    public Pais getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("País não encontrado"));
    }
	
	public Pais savePais(PaisDTO dto) {
		return repository.save(new Pais(dto));
	}
	
	public Pais updatePais(Long id, PaisDTO dto) {
		Pais pais =  getById(id);
		return repository.save(pais.updatePais(dto));
	}
	//TO-DO fazer throw exception
	public void deletePais(Long id) {
        repository.deleteById(id);
    }
	
}
