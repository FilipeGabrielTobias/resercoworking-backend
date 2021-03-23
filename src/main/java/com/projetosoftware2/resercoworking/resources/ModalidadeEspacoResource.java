package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.services.ModalidadeEspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modalidadeEspaco")
public class ModalidadeEspacoResource {

    @Autowired
    private ModalidadeEspacoService modalidadeEspacoService;

    @GetMapping
    public List<ModalidadeEspaco> getModalidades(){
        return modalidadeEspacoService.selectModalidade();
    }

    @PostMapping
    public void insertModalidade(){

        modalidadeEspacoService.insertModalidadeEspaco(1l,"modalidade1","desc1");
    }
    @DeleteMapping
    public void deleteModalidadeEspaco(){
        modalidadeEspacoService.deleteModalidadeEspaco(modalidadeEspacoService.m1.findByNome("modalidade1"));
    }
    @PutMapping
    public void updateModalidade(){
        modalidadeEspacoService.updateModalidadeEspaco(modalidadeEspacoService.m1.findByNome("modalidade1"),"modalidadeNova","descNova");
    }
}
