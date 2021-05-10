package com.projetosoftware2.resercoworking.controllers;

import com.projetosoftware2.resercoworking.domain.Arquivo;
import com.projetosoftware2.resercoworking.services.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/common/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping
    public Arquivo inserirArquivo(@RequestParam("file") MultipartFile file) throws IOException {
        return arquivoService.inserirArquivo(file);
    }

//    @PutMapping
//    public Arquivo atualizarArquivo(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
//
//    }
//
//    @DeleteMapping("{id}")
//    public void excluirArquivo(@PathVariable Long id) {
//
//    }
}
