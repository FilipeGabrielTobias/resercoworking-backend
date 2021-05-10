package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoResumoDto;
import com.projetosoftware2.resercoworking.domain.enums.SituacaoReservaEspaco;
import com.projetosoftware2.resercoworking.domain.mappers.ReservaEspacoCancelamentoMapper;
import com.projetosoftware2.resercoworking.domain.mappers.ReservaEspacoMapper;
import com.projetosoftware2.resercoworking.repositories.FeedbackEspacoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoCancelamentoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ReservaEspaco saveReserva(ReservaEspacoDto dto) {
        return reservaEspacoRepository.save(reservaEspacoMapper.toReservaEspaco(dto));
    }

    public ReservaEspacoCancelamento cancelarReservaEspaco(ReservaEspacoCancelamentoDto dto) {
        ReservaEspaco reserva = getReservaById(dto.getReservaEspaco().getId());
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.CANCELADO);
        reservaEspacoRepository.save(reserva);
        /*Atualiza Pontuacao retira os pontos pois a reserva foi cancelada*/
        int qtPontos = reserva.getQuantidadePontosTotal();
        long idUsuario = reserva.getUsuarioReservou().getId();
        usuarioService.atualizaPontuacao(idUsuario, qtPontos, true);
        
        return reservaEspacoCancelamentoRepository.save(reservaEspacoCancelamentoMapper.toReservaEspacoCancelamento(dto));
    }
    
    public ReservaEspaco finalizarReserva(Long reservaId) {
    	ReservaEspaco reserva = getReservaById(reservaId);
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.FINALIZADO);

        /*Atualiza Pontuacao adiciona os pontos*/
        int qtPontos = reserva.getQuantidadePontosTotal();
        long idUsuario = reserva.getUsuarioReservou().getId();
        usuarioService.atualizaPontuacao(idUsuario, qtPontos, false);
        
        return reservaEspacoRepository.save(reserva);
    }
    
    public ReservaEspaco adicionaFeedBack(Long reservaId, Long feedBackEspacoId) {
    	ReservaEspaco reserva = reservaEspacoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
//    	FeedbackEspaco feedBackEspaco = feedBackEspacoRepository.findById(feedBackEspacoId)
//    			.orElseThrow(() -> new ObjectNotFoundException("FeedBack Não encontrado"));
//    	reserva.setFeedBackEspaco(feedBackEspaco);
    	return reservaEspacoRepository.save(reserva);
    }
}
