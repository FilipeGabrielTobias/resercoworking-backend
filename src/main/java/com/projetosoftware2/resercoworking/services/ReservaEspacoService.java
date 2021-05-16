package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoResumoDto;
import com.projetosoftware2.resercoworking.domain.enums.SituacaoReservaEspaco;
import com.projetosoftware2.resercoworking.domain.mappers.FeedbackEspacoMapper;
import com.projetosoftware2.resercoworking.domain.mappers.ReservaEspacoCancelamentoMapper;
import com.projetosoftware2.resercoworking.domain.mappers.ReservaEspacoMapper;
import com.projetosoftware2.resercoworking.repositories.FeedbackEspacoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoCancelamentoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReservaEspacoService {

    @Autowired
    private ReservaEspacoRepository reservaEspacoRepository;

    @Autowired
    private ReservaEspacoCancelamentoRepository reservaEspacoCancelamentoRepository;
    
    @Autowired
    private FeedbackEspacoRepository feedBackEspacoRepository;

    @Autowired
    private ReservaEspacoMapper reservaEspacoMapper;

    @Autowired
    private FeedbackEspacoMapper feedbackEspacoMapper;

    @Autowired
    private ReservaEspacoCancelamentoMapper reservaEspacoCancelamentoMapper;
    
    @Autowired
	private UsuarioService usuarioService;
    
    public List<ReservaEspacoResumoDto> getAllReservas() {
        return reservaEspacoMapper.toReservasEspacosResumoDto(reservaEspacoRepository.findAll());
    }

    public ReservaEspaco getReservaById(Long reservaId) {
        return reservaEspacoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
    }

    public ReservaEspaco reservarEspaco(ReservaEspacoDto dto) {
        return reservaEspacoRepository.save(reservaEspacoMapper.toReservaEspaco(dto));
    }

    public ReservaEspacoCancelamento cancelarReservaEspaco(ReservaEspacoCancelamentoDto dto) {
        ReservaEspaco reserva = getReservaById(dto.getReservaEspaco().getId());
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.CANCELADO);
        reservaEspacoRepository.save(reserva);
        if (Objects.nonNull(reserva.getUsuarioReservou().getQuantidadePontos()) && reserva.getUsuarioReservou().getQuantidadePontos() != 0) {
            usuarioService.atualizaPontuacao(reserva.getUsuarioReservou().getId(), reserva.getQuantidadePontosTotal(), true);
        }
        return reservaEspacoCancelamentoRepository.save(reservaEspacoCancelamentoMapper.toReservaEspacoCancelamento(dto));
    }
    
    public ReservaEspaco finalizarReserva(Long reservaId, FeedbackEspacoDto feedbackEspacoDto) {
    	ReservaEspaco reserva = getReservaById(reservaId);
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.FINALIZADO);
        usuarioService.atualizaPontuacao(reserva.getUsuarioReservou().getId(), reserva.getQuantidadePontosTotal(), false);
        feedBackEspacoRepository.save(feedbackEspacoMapper.toFeedbackEspaco(feedbackEspacoDto));
        return reservaEspacoRepository.save(reserva);
    }
}
