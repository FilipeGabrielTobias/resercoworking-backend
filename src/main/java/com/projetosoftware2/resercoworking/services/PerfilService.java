package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.dto.PerfilDTO;
import com.projetosoftware2.resercoworking.repositories.PerfilRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
   
	@Autowired
	private PerfilRepository repository;
	
	public Perfil save(PerfilDTO perfilDTO) {				
		return repository.save(new Perfil(perfilDTO));
	}
	
	public List<Perfil> getAll() {
		return repository.findAll();
	}


    public Perfil getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Perfil não encontrado"));
    }

    public Perfil updatePerfil(Long id, PerfilDTO dto) {
       Perfil perfil = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Perfil não encontrado"));
        return repository.save(perfil.updatePerfil(dto));
    }

    public void deletePerfil(Long id) {
        repository.deleteById(id);
    }
}


