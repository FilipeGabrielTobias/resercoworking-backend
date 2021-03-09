package com.projetosoftware2.resercoworking.interactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.repositories.PerfilRepository;

@Service
public class PerfilAdition {
   
	@Autowired
	private PerfilRepository repository;
	
	public Perfil save(Perfil perfil) {				
		return repository.save( perfil );
	}
	
	public List<Perfil> getAll() {
		return repository.findAll();
	}
}


