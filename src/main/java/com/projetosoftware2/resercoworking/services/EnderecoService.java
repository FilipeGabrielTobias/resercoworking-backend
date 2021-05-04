package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Endereco;
import com.projetosoftware2.resercoworking.dto.EnderecoDTO;
import com.projetosoftware2.resercoworking.repositories.EnderecoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
     
	@Autowired
    private EnderecoRepository repository;
	
	public List<Endereco> getAll() {
		return repository.findAll();
	}

    public Endereco getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Endereço não encontrado"));
    }
	
	public Endereco saveEndereco(EnderecoDTO dto) {
		return repository.save(new Endereco(dto));
	}
	
	public Endereco updateEndereco(Long id, EnderecoDTO dto) {
		Endereco endereco =  getById(id);
		return repository.save(endereco.updateEndereco(dto));
	}
	
	public void deleteEndereco(Long id) throws ObjectNotFoundException {		
        repository.deleteById(id);
    }
}
