package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.domain.dto.ModalidadeEspacoDto;
import com.projetosoftware2.resercoworking.domain.mappers.ModalidadeEspacoMapper;
import com.projetosoftware2.resercoworking.repositories.ModalidadeEspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadeEspacoService {
    @Autowired
    private ModalidadeEspacoRepository modalidadeEspacoRepository;
    @Autowired
    private ModalidadeEspacoMapper modalidadeEspacoMapper;

    public ModalidadeEspaco insertModalidadeEspaco(ModalidadeEspacoDto dto) {
        return modalidadeEspacoRepository.save(modalidadeEspacoMapper.toModalidadeEspaco(dto));
    }

    public void deleteModalidadeEspaco(Long id) {
        modalidadeEspacoRepository.delete(getModalidadeEspacoById(id));
    }

    public ModalidadeEspaco updateModalidadeEspaco(Long id, ModalidadeEspacoDto dto) {
        ModalidadeEspaco modalidadeEspaco = getModalidadeEspacoById(id);
        return modalidadeEspacoRepository.save(modalidadeEspacoMapper.updateModalidadeEspaco(dto, modalidadeEspaco));
    }

    public List<ModalidadeEspaco> selectModalidade() {
        return modalidadeEspacoRepository.findAll();
    }

    public ModalidadeEspaco getModalidadeEspacoById(Long id) {
        return modalidadeEspacoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Modalidade de Espaço não encontrada"));
    }
}
