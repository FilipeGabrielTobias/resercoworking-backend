package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoCancelamentoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaEspacoCancelamentoMapper {

    ReservaEspacoCancelamento toReservaEspacoCancelamento(ReservaEspacoCancelamentoDto dto);

    ReservaEspacoCancelamentoDto toReservaEspacoCancelamentoDto(ReservaEspacoCancelamento reservaEspacoCancelamento);
}
