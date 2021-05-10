package com.projetosoftware2.resercoworking.services;

import java.util.List;

import com.projetosoftware2.resercoworking.domain.mappers.PerfilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.domain.dto.PerfilDto;
import com.projetosoftware2.resercoworking.repositories.PerfilRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
   
	@Autowired
	private PerfilRepository repository;
	@Autowired
	private PerfilMapper perfilMapper;
	
	public Perfil save(PerfilDto perfilDto) {
		return repository.save(perfilMapper.toPerfil(perfilDto));
	}
	
	public List<Perfil> getAll() {
		return repository.findAll();
	}

    public Perfil getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Perfil não encontrado"));
    }

    public Perfil updatePerfil(Long id, PerfilDto dto) {
       Perfil perfil = getById(id);
        return repository.save(perfilMapper.updatePerfil(dto, perfil));
    }

    public void deletePerfil(Long id) {
        repository.delete(getById(id));
    }
}


