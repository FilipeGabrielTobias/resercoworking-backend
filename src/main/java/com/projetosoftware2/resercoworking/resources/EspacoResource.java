package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.domain.Espaco;
import com.projetosoftware2.resercoworking.domain.Premiacao;
import com.projetosoftware2.resercoworking.dto.EspacoDto;
import com.projetosoftware2.resercoworking.dto.PremiacaoDto;
import com.projetosoftware2.resercoworking.services.EspacoService;
import com.projetosoftware2.resercoworking.services.PremiacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space")
public class EspacoResource {

    @Autowired
    private EspacoService espacoService;

    @GetMapping
    public List<Espaco> getEspacos() {
        return espacoService.getAllEspaco();
    }

    @GetMapping("/{espacoId}")
    public Espaco getByIdEspaco(@PathVariable Long espacoId) {
        return espacoService.getByIdEspaco(espacoId);
    }

    @PostMapping
    public Espaco saveEspaco(@RequestBody EspacoDto dto) {
        return espacoService.saveEspaco(dto);
    }

    @PutMapping("/{espacoId}")
    public Espaco updateEspaco(@PathVariable Long espacoId, @RequestBody EspacoDto dto) {
        return espacoService.updateEspaco(espacoId, dto);
    }

    @DeleteMapping("/{espacoId}")
    public void deleteEspaco(@PathVariable Long espacoId) {
        espacoService.deleteEspaco(espacoId);
    }
}
