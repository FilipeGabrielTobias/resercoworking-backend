package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Bairro;
import com.projetosoftware2.resercoworking.dto.BairroDTO;
import com.projetosoftware2.resercoworking.repositories.BairroRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class BairroService {
  
	@Autowired
    private BairroRepository repository;
	
	public List<Bairro> getAll() {
		return repository.findAll();
	}

    public Bairro getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Bairro não encontrado"));
    }
	
	public Bairro saveBairro(BairroDTO dto) {
		return repository.save(new Bairro(dto));
	}
	
	public Bairro updateBairro(Long id, BairroDTO dto) {
		Bairro bairro =  getById(id);
		return repository.save(bairro.updateBairro(dto));
	}
	
	public void deleteBairro(Long id) throws ObjectNotFoundException {		
        repository.deleteById(id);
    }
}
