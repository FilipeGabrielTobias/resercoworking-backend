package com.projetosoftware2.resercoworking.controllers;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;
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
    public List<ReservaEspacoResumoDto> getReservasEspaco() {
        return reservaEspacoService.getAllReservas();
    }

    @GetMapping("/{reservaEspacoId}")
    public ReservaEspaco getReservaById(@PathVariable Long reservaEspacoId) {
        return reservaEspacoService.getReservaById(reservaEspacoId);
    }

    @PostMapping
    public ReservaEspaco reservarEspaco(@RequestBody ReservaEspacoDto dto) {
        return reservaEspacoService.reservarEspaco(dto);
    }

    @PostMapping("/{reservaEspacoId}/finalizar-reserva")
    public ReservaEspaco finalizarReservaEspaco(@PathVariable Long reservaEspacoId, @RequestBody FeedbackEspacoDto feedbackEspacoDto) {
        return reservaEspacoService.finalizarReserva(reservaEspacoId, feedbackEspacoDto);
    }

    @PostMapping("/cancelar-reserva")
    public void cancelarReservaEspaco(@RequestBody ReservaEspacoCancelamentoDto dto) {
        reservaEspacoService.cancelarReservaEspaco(dto);
    }
}
