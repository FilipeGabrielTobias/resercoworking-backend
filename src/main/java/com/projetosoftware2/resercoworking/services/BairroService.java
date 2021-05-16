package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Bairro;
import com.projetosoftware2.resercoworking.domain.dto.BairroDto;
import com.projetosoftware2.resercoworking.repositories.BairroRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	
	public Bairro saveBairro(BairroDto dto) {
		return repository.save(new Bairro(dto));
	}
	
	public Bairro updateBairro(Long id, BairroDto dto) {
		Bairro bairro =  getById(id);
		return repository.save(bairro.updateBairro(dto));
	}
	
	public void deleteBairro(Long id) throws ObjectNotFoundException {		
        repository.deleteById(id);
    }
}
