package com.projetosoftware2.resercoworking.controllers;

import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.domain.dto.PerfilDto;
import com.projetosoftware2.resercoworking.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
  
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> getPremiacoes() {
        return perfilService.getAll();
    }

    @GetMapping("/{id}")
    public Perfil getByIdPerfil(@PathVariable Long id) {
        return perfilService.getById(id);
    }

    @PostMapping
    public Perfil savePerfil(@RequestBody PerfilDto dto) {
        return perfilService.save(dto);
    }

    @PutMapping("/{PerfilId}")
    public Perfil updatePerfil(@PathVariable Long PerfilId, @RequestBody PerfilDto dto) {
        return perfilService.updatePerfil(PerfilId, dto);
    }

    @DeleteMapping("/{PerfilId}")
    public void deletePerfil(@PathVariable Long PerfilId) {
        perfilService.deletePerfil(PerfilId);
    }
     
}
