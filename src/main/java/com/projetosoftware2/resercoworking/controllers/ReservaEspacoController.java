package com.projetosoftware2.resercoworking.controllers;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoResumoDto;
import com.projetosoftware2.resercoworking.services.ReservaEspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva-espaco")
public class ReservaEspacoController {

    @Autowired
    private ReservaEspacoService reservaEspacoService;

    @GetMapping
    public List<ReservaEspacoResumoDto> getEspacos() {
        return reservaEspacoService.getAllReservas();
    }

    @GetMapping("/{espacoId}")
    public ReservaEspaco getByIdEspaco(@PathVariable Long espacoId) {
        return reservaEspacoService.getReservaById(espacoId);
    }

    @PostMapping
    public ReservaEspaco saveEspaco(@RequestBody ReservaEspacoDto dto) {
        return reservaEspacoService.saveReserva(dto);
    }

    @DeleteMapping("/{espacoId}")
    public void deleteEspaco(@PathVariable Long espacoId) {
        reservaEspacoService.cancelarReservaEspaco(new ReservaEspacoCancelamentoDto());
    }
}
