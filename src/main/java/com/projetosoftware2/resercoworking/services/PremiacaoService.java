package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import com.projetosoftware2.resercoworking.domain.dto.PremiacaoDto;
import com.projetosoftware2.resercoworking.domain.mappers.PremiacaoMapper;
import com.projetosoftware2.resercoworking.repositories.PremiacaoRepository;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiacaoService {

    @Autowired
    private PremiacaoRepository premiacaoRepository;
    @Autowired
    private PremiacaoMapper premiacaoMapper;

    public List<Premiacao> getPremiacoes() {
        return premiacaoRepository.findAll();
    }

    public Premiacao getByIdPremiacao(Long premiacaoId) {
        return premiacaoRepository.findById(premiacaoId)
                .orElseThrow(() -> new ObjectNotFoundException("Premiação não encontrada"));
    }

    public Premiacao savePremiacao(PremiacaoDto dto) {
        return premiacaoRepository.save(premiacaoMapper.toPremiacao(dto));
    }

    public Premiacao updatePremiacao(Long premiacaoId, PremiacaoDto dto) {
        Premiacao premiacao = getByIdPremiacao(premiacaoId);
        return premiacaoRepository.save(premiacaoMapper.updatePremiacao(dto, premiacao));
    }

    public void deletePremiacao(Long premiacaoId) {
        premiacaoRepository.delete(getByIdPremiacao(premiacaoId));
    }
}
