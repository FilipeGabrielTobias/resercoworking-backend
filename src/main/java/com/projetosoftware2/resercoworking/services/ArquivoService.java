package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Arquivo;
import com.projetosoftware2.resercoworking.repositories.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    public Arquivo inserirArquivo(MultipartFile file) throws IOException {
        Arquivo arquivo = new Arquivo();
        arquivo.setNome(file.getName());
        arquivo.setTipo(file.getContentType());
        arquivo.setConteudo(file.getBytes());
        return arquivoRepository.save(arquivo);
    }
}
