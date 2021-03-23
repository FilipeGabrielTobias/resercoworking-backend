package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.domain.Usuario;
import com.projetosoftware2.resercoworking.repositories.ModalidadeEspacoRepository;
import com.projetosoftware2.resercoworking.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeEspacoService {
    @Autowired
    public ModalidadeEspacoRepository m1;


        public void insertModalidadeEspaco(Long id, String nome, String desc) {
            ModalidadeEspaco modalidade = new ModalidadeEspaco();
            modalidade.setId(id);
            modalidade.setNome(nome);
            modalidade.setDescricao(desc);
            m1.save(modalidade);
        }
        public void deleteModalidadeEspaco(ModalidadeEspaco modalidade){
            m1.delete(modalidade);
        }

        public void updateModalidadeEspaco(ModalidadeEspaco modalidade, String novoNome, String novaDescricao){
            modalidade.setNome(novoNome);
            modalidade.setDescricao(novaDescricao);
            m1.save(modalidade);
        }

        public List<ModalidadeEspaco> selectModalidade() {
            return m1.findAll();
        }

}
