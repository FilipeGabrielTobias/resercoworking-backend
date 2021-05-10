package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import com.projetosoftware2.resercoworking.domain.dto.PremiacaoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PremiacaoMapper {

    Premiacao toPremiacao(PremiacaoDto dto);

    Premiacao updatePremiacao(PremiacaoDto dto, @MappingTarget Premiacao premiacao);

    PremiacaoDto toPremiacaoDto(Premiacao premiacao);

    List<PremiacaoDto> toPremiacoesDto(Collection<Premiacao> premiacoes);
}
