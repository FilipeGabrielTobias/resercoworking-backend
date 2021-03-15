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
    public List<Espaco> getPremiacoes() {
        return espacoService.getAllEspaco();
    }

    @GetMapping("/{espacoId}")
    public Espaco getByIdPremiacao(@PathVariable Long espacoId) {
        return espacoService.getByIdEspaco(espacoId);
    }

    @PostMapping
    public Espaco savePermiacao(@RequestBody EspacoDto dto) {
        return espacoService.saveEspaco(dto);
    }

    @PutMapping("/{espacoId}")
    public Espaco updatePremiacao(@PathVariable Long espacoId, @RequestBody EspacoDto dto) {
        return espacoService.updateEspaco(espacoId, dto);
    }

    @DeleteMapping("/{espacoId}")
    public void deletePremiacao(@PathVariable Long espacoId) {
        espacoService.deleteEspaco(espacoId);
    }
}
