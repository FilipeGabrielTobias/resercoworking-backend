package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.domain.dto.ModalidadeEspacoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ModalidadeEspacoMapper {

    ModalidadeEspaco toModalidadeEspaco(ModalidadeEspacoDto dto);

    ModalidadeEspaco updateModalidadeEspaco(ModalidadeEspacoDto dto, @MappingTarget ModalidadeEspaco modalidadeEspaco);

    ModalidadeEspacoDto toModalidadeEspacoDto(ModalidadeEspaco modalidadeEspaco);

    List<ModalidadeEspacoDto> toModalidadesEspacoDto(Collection<ModalidadeEspaco> modalidades);
}
