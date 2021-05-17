package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Espaco;
import com.projetosoftware2.resercoworking.domain.dto.EspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.EspacoResumoDto;
import com.projetosoftware2.resercoworking.domain.mappers.EspacoMapper;
import com.projetosoftware2.resercoworking.repositories.EspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository espacoRepository;
    @Autowired
    private EspacoMapper espacoMapper;

    public List<EspacoResumoDto> getAllEspaco() {
        return espacoMapper.toEspacosResumoDto(espacoRepository.findAll());
    }

    public Espaco getByIdEspaco(Long espacoId) {
        return espacoRepository.findById(espacoId)
                .orElseThrow(() -> new ObjectNotFoundException("Espaço não encontrado"));
    }

    public Espaco saveEspaco(EspacoDto dto) {
        return espacoRepository.save(espacoMapper.toEspaco(dto));
    }

    public Espaco updateEspaco(Long espacoId, EspacoDto dto) {
        Espaco espaco = getByIdEspaco(espacoId);
        return espacoRepository.save(espacoMapper.updateEspaco(dto, espaco));
    }

    public void deleteEspaco(Long espacoId) {
        espacoRepository.delete(getByIdEspaco(espacoId));
    }

    public void atualizaNota() {

    }
}
