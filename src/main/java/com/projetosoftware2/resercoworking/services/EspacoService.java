package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Espaco;
import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.dto.EspacoDto;
import com.projetosoftware2.resercoworking.repositories.EspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository espacoRepository;

    public List<Espaco> getAllEspaco() {
        return espacoRepository.findAll();
    }

    public Espaco getByIdEspaco(Long espacoId) {
        return espacoRepository.findById(espacoId)
                .orElseThrow(() -> new ObjectNotFoundException("Espaço não encontrado"));
    }

    public Espaco saveEspaco(EspacoDto dto) {
//        TODO: ajustar para pegar a modalidade de espaco informada
        ModalidadeEspaco modalidadeEspaco = new ModalidadeEspaco();
        return espacoRepository.save(new Espaco(dto, modalidadeEspaco));
    }

    public Espaco updateEspaco(Long espacoId, EspacoDto dto) {
//        TODO: ajustar para pegar a modalidade de espaco informada
        ModalidadeEspaco modalidadeEspaco = new ModalidadeEspaco();
        Espaco espaco = espacoRepository.findById(espacoId)
                .orElseThrow(() -> new ObjectNotFoundException("Espaço não encontrado"));
        return espacoRepository.save(espaco.updateEspaco(dto, modalidadeEspaco));
    }

    public void deleteEspaco(Long espacoId) {
        espacoRepository.deleteById(espacoId);
    }
}
