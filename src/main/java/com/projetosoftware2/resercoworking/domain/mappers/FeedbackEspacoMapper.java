package com.projetosoftware2.resercoworking.domain.mappers;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;
import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackEspacoMapper {

    FeedbackEspaco toFeedbackEspaco(FeedbackEspacoDto dto);

    FeedbackEspacoDto toFeedbackEspacoDto(FeedbackEspaco feedbackEspaco);
}
