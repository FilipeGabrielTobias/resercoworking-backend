package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.dto.ModalidadeEspacoDto;
import com.projetosoftware2.resercoworking.repositories.ModalidadeEspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadeEspacoService {
    @Autowired
    public ModalidadeEspacoRepository modalidadeEspacoRepository;


    public ModalidadeEspaco insertModalidadeEspaco(ModalidadeEspaco dto) {
//        ModalidadeEspaco modalidade = new ModalidadeEspaco(dto);
        return modalidadeEspacoRepository.save(dto);
    }

    public void deleteModalidadeEspaco(Long id) {
        modalidadeEspacoRepository.deleteById(id);
    }

    public ModalidadeEspaco updateModalidadeEspaco(Long id, ModalidadeEspaco dto) {
        ModalidadeEspaco modalidadeEspaco = modalidadeEspacoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Modalidade de espaço não encontrada"));
        return modalidadeEspacoRepository.save(modalidadeEspaco.updateModalidadeEspaco(dto));
    }

    public List<ModalidadeEspaco> selectModalidade() {
        return modalidadeEspacoRepository.findAll();
    }

    public ModalidadeEspaco getModalidadeEspacoById(Long id) {
        return modalidadeEspacoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Modalidade de Espaço não encontrada"));
    }
}
