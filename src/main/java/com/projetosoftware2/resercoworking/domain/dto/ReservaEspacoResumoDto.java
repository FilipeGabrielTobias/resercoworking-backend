package com.projetosoftware2.resercoworking.domain.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEspacoResumoDto {

    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Espaco espaco;
    private Usuario usuarioReservou;

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
