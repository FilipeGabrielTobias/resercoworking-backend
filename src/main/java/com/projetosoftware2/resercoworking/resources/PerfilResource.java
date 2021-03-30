package com.projetosoftware2.resercoworking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.dto.PerfilDTO;
import com.projetosoftware2.resercoworking.services.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {
  
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
    public Perfil savePerfil(@RequestBody  PerfilDTO dto) {
        return perfilService.save(dto);
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
