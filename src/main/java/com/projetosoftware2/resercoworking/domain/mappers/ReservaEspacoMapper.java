package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.ReservaEspacoResumoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaEspacoMapper {

    ReservaEspaco toReservaEspaco(ReservaEspacoDto dto);

    ReservaEspaco updateReservaEspaco(ReservaEspacoDto dto, @MappingTarget ReservaEspaco reservaEspaco);

    ReservaEspacoDto toReservaEspacoDto(ReservaEspaco reservaEspaco);

    List<ReservaEspacoResumoDto> toReservasEspacosResumoDto(Collection<ReservaEspaco> reservas);
}
