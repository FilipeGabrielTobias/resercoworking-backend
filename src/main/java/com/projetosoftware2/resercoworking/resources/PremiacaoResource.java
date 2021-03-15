package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import com.projetosoftware2.resercoworking.dto.PremiacaoDto;
import com.projetosoftware2.resercoworking.services.PremiacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/awards")
public class PremiacaoResource {

    @Autowired
    private PremiacaoService premiacaoService;

    @GetMapping
    public List<Premiacao> getPremiacoes() {
        return premiacaoService.getPremiacoes();
    }

    @GetMapping("/{premiacaoId}")
    public Premiacao getByIdPremiacao(@PathVariable Long premiacaoId) {
        return premiacaoService.getByIdPremiacao(premiacaoId);
    }

    @PostMapping
    public Premiacao savePermiacao(@RequestBody PremiacaoDto dto) {
        return premiacaoService.savePremiacao(dto);
    }

    @PutMapping("/{premiacaoId}")
    public Premiacao updatePremiacao(@PathVariable Long premiacaoId, @RequestBody PremiacaoDto dto) {
        return premiacaoService.updatePremiacao(premiacaoId, dto);
    }

    @DeleteMapping("/{premiacaoId}")
    public void deletePremiacao(@PathVariable Long premiacaoId) {
        premiacaoService.deletePremiacao(premiacaoId);
    }
}
