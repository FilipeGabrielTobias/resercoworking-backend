package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.enums.SituacaoReservaEspaco;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEspacoResumoDto {

    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;
    private Espaco espaco;
    private Usuario usuarioReservou;
    private SituacaoReservaEspaco situacaoReservaEspaco;

    @Data
    public static class Espaco {
        private Long id;
        private String nome;
    }

    @Data
    public static class Usuario {
        private Long id;
        private String nome;
    }

}
