package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import com.projetosoftware2.resercoworking.dto.PremiacaoDto;
import com.projetosoftware2.resercoworking.repositories.PremiacaoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiacaoService {

    @Autowired
    private PremiacaoRepository premiacaoRepository;

    public List<Premiacao> getPremiacoes() {
        return premiacaoRepository.findAll();
    }

    public Premiacao getByIdPremiacao(Long premiacaoId) {
        return premiacaoRepository.findById(premiacaoId)
                .orElseThrow(() -> new ObjectNotFoundException("Premiação não encontrada"));
    }

    public Premiacao savePremiacao(Premiacao dto) {
        return premiacaoRepository.save(dto);
    }

    public Premiacao updatePremiacao(Long premiacaoId, Premiacao dto) {
        Premiacao premiacao = premiacaoRepository.findById(premiacaoId)
                .orElseThrow(() -> new ObjectNotFoundException("Premiação não encontrada"));
        return premiacaoRepository.save(premiacao.updatePremiacao(dto));
    }

    public void deletePremiacao(Long premiacaoId) {
        premiacaoRepository.deleteById(premiacaoId);
    }
}
