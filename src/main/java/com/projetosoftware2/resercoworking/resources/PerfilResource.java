package com.projetosoftware2.resercoworking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.dto.PerfilDTO;
import com.projetosoftware2.resercoworking.services.PerfilService;

public class PerfilResource {
  
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> getPremiacoes() {
        return perfilService.getAll();
    }

    @GetMapping("/{PerfilId}")
    public Perfil getByIdPerfil(@PathVariable Long id) {
        return perfilService.getById(id);
    }

    @PostMapping
    public Perfil savePerfil(@RequestBody  PerfilDTO dto) {
        return perfilService.savePerfil(dto);
    }

    @PutMapping("/{PerfilId}")
    public Perfil updatePerfil(@PathVariable Long PerfilId, @RequestBody  PerfilDTO dto) {
        return perfilService.updatePerfil(PerfilId, dto);
    }

    @DeleteMapping("/{PerfilId}")
    public void deletePerfil(@PathVariable Long PerfilId) {
        perfilService.deletePerfil(PerfilId);
    }
     
}
