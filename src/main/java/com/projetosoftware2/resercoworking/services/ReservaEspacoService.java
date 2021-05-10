package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.FeedBackEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.domain.SituacaoReservaEspaco;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoCancelamentoDto;
import com.projetosoftware2.resercoworking.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.repositories.FeedBackEspacoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoCancelamentoRepository;
import com.projetosoftware2.resercoworking.repositories.ReservaEspacoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaEspacoService {

    @Autowired
    private ReservaEspacoRepository reservaEspacoRepository;

    @Autowired
    private ReservaEspacoCancelamentoRepository reservaEspacoCancelamentoRepository;
    
    @Autowired
    private FeedBackEspacoRepository feedBackEspacoRepository;
    
    @Autowired
	private UsuarioService usuarioService;
    
    public List<ReservaEspaco> getAllReservas() {
        return reservaEspacoRepository.findAll();
    }

    public ReservaEspaco getReservaById(Long reservaId) {
        return reservaEspacoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
    }

    public ReservaEspaco saveReserva(ReservaEspacoDto dto) {
        return reservaEspacoRepository.save(new ReservaEspaco(dto));
    }

    public ReservaEspacoCancelamento cancelarReservaEspaco(ReservaEspacoCancelamentoDto dto) {
        ReservaEspaco reserva = reservaEspacoRepository.findById(dto.getReservaEspaco().getId())
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.CANCELADO);
        ReservaEspacoCancelamento reservaEspacoCancelamento = new ReservaEspacoCancelamento(dto);
        reservaEspacoRepository.save(reserva);
        /*Atualiza Pontuacao retira os pontos pois a reserva foi cancelada*/
        int qtPontos = reserva.getQtPontosTotal();
        long idUsuario = reserva.getUsuarioReservou().getId();
        usuarioService.atualizaPontuacao(idUsuario, qtPontos, true);
        
        return reservaEspacoCancelamentoRepository.save(reservaEspacoCancelamento);
    }
    
    public ReservaEspaco finalizarReserva(Long reservaId) {
    	ReservaEspaco reserva = reservaEspacoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
        reserva.setSituacaoReservaEspaco(SituacaoReservaEspaco.FINALIZADO);
        reserva.setDataFinal(LocalDate.now());
        
        /*Atualiza Pontuacao adiciona os pontos*/
        int qtPontos = reserva.getQtPontosTotal();
        long idUsuario = reserva.getUsuarioReservou().getId();
        usuarioService.atualizaPontuacao(idUsuario, qtPontos, false);
        
        return reservaEspacoRepository.save(reserva);
    }
    
    public ReservaEspaco adicionaFeedBack(Long reservaId, Long feedBackEspacoId) {//passar feedback
    	ReservaEspaco reserva = reservaEspacoRepository.findById(reservaId)
                .orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada"));
    	FeedBackEspaco feedBackEspaco = feedBackEspacoRepository.findById(feedBackEspacoId)
    			.orElseThrow(() -> new ObjectNotFoundException("FeedBack Não encontrado"));
    	reserva.setFeedBackEspaco(feedBackEspaco);
    	return reservaEspacoRepository.save(reserva);
    }
}
