package com.projetosoftware2.resercoworking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosoftware2.resercoworking.domain.Estado;
import com.projetosoftware2.resercoworking.dto.EstadoDTO;
import com.projetosoftware2.resercoworking.repositories.EstadoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

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
	
	public Estado saveEstado(EstadoDTO dto) {
		return repository.save(new Estado(dto));
	}
	
	public Estado updateEstado(Long id, EstadoDTO dto) {
	   Estado estado = getById(id);
       return repository.save(estado.updateEstado(dto));
	}


	public void deleteEstado(Long estadoId) {
		repository.deleteById(estadoId);
	}
	
}
