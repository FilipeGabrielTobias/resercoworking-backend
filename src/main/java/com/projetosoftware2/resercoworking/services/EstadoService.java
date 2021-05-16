package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Estado;
import com.projetosoftware2.resercoworking.domain.dto.EstadoDto;
import com.projetosoftware2.resercoworking.repositories.EstadoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> getAll() {
		return repository.findAll();
	}


    public Estado getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado"));
    }
	
	public Estado saveEstado(EstadoDto dto) {
		return repository.save(new Estado(dto));
	}
	
	public Estado updateEstado(Long id, EstadoDto dto) {
	   Estado estado = getById(id);
       return repository.save(estado.updateEstado(dto));
	}


	public void deleteEstado(Long estadoId) {
		repository.deleteById(estadoId);
	}
	
}
