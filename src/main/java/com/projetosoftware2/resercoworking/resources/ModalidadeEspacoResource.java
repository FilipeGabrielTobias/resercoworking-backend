package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.dto.ModalidadeEspacoDto;
import com.projetosoftware2.resercoworking.services.ModalidadeEspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidadeEspaco")
public class ModalidadeEspacoResource {

    @Autowired
    private ModalidadeEspacoService modalidadeEspacoService;

    @GetMapping
    public List<ModalidadeEspaco> getModalidades(){
        return modalidadeEspacoService.selectModalidade();
    }

    @GetMapping("{id}")
    public ModalidadeEspaco getModalidadeEspacoById(@PathVariable Long id) {
        return modalidadeEspacoService.getModalidadeEspacoById(id);
    }

    @PostMapping
    public ModalidadeEspaco insertModalidade(@RequestBody ModalidadeEspaco dto){
        return modalidadeEspacoService.insertModalidadeEspaco(dto);
    }
    @DeleteMapping("{id}")
    public void deleteModalidadeEspaco(@PathVariable Long id){
        modalidadeEspacoService.deleteModalidadeEspaco(id);
    }
    @PutMapping("{id}")
    public ModalidadeEspaco updateModalidade(@PathVariable Long id, @RequestBody ModalidadeEspaco dto){
        return modalidadeEspacoService.updateModalidadeEspaco(id, dto);
    }
}
