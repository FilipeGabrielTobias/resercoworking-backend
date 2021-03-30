package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.domain.SituacaoReservaEspaco;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.repositories.ReservaEsparcoCancelamentoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEsparcoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaEspacoService {

    @Autowired
    private ReservaEsparcoRepository reservaEsparcoRepository;

    @Autowired
    private ReservaEsparcoCancelamentoRepository reservaEsparcoCancelamentoRepository;

    public List<ReservaEspaco> getAllReservas() {
        return reservaEsparcoRepository.findAll();
    }

    public ReservaEspaco getReservaById(Long reservaId) {
        return reservaEsparcoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
    }

    public ReservaEspaco saveReserva(ReservaEspacoDto dto) {
        return reservaEsparcoRepository.save(new ReservaEspaco(dto));
    }

    public ReservaEspacoCancelamento cancelarReservaEspaco(ReservaEspacoCancelamentoDto dto) {
        ReservaEspaco reserva = reservaEsparcoRepository.findById(dto.getReservaEspaco().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.CANCELADO);
        ReservaEspacoCancelamento reservaEspacoCancelamento = new ReservaEspacoCancelamento(dto);
        reservaEsparcoRepository.save(reserva);
        return reservaEsparcoCancelamentoRepository.save(reservaEspacoCancelamento);
    }
}
