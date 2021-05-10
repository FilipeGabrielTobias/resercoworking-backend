package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Cidade;
import com.projetosoftware2.resercoworking.domain.dto.CidadeDto;
import com.projetosoftware2.resercoworking.repositories.CidadeRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> getAll() {
		return repository.findAll();
	}

    public Cidade getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada"));
    }
	
	public Cidade saveCidade(CidadeDto dto) {
		return repository.save(new Cidade(dto));
	}
	
	public Cidade updateCidade(Long id, CidadeDto dto) {
		Cidade cidade =  getById(id);
		return repository.save(cidade.updateCidade(dto));
	}
	
	public void deleteCidade(Long id) throws ObjectNotFoundException {		
        repository.deleteById(id);
    }

}
