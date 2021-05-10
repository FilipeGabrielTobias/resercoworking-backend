package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.Espaco;
import com.projetosoftware2.resercoworking.domain.dto.EspacoDto;
import com.projetosoftware2.resercoworking.domain.dto.EspacoResumoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EspacoMapper {

    Espaco toEspaco(EspacoDto dto);

    Espaco updateEspaco(EspacoDto dto, @MappingTarget Espaco espaco);

    EspacoDto toEspacoDto(Espaco espaco);

    List<EspacoResumoDto> toEspacosResumoDto(Collection<Espaco> espacos);
}
