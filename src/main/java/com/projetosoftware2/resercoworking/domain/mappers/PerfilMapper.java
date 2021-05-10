package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.domain.dto.PerfilDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

    Perfil toPerfil(PerfilDto dto);

    Perfil updatePerfil(PerfilDto dto, @MappingTarget Perfil perfil);

    PerfilDto toPerfilDto(Perfil perfil);

    List<PerfilDto> toPerfisDto(Collection<Perfil> perfis);
}
