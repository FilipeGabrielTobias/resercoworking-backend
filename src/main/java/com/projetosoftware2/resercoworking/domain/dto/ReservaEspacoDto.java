package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;
import com.projetosoftware2.resercoworking.domain.enums.FormaPagamento;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEspacoDto {

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private FormaPagamento formaPagamento;
    private Espaco espaco;
    private Usuario usuarioReservou;
    private FeedbackEspaco feedbackEspaco;

    @Data
    public static class Espaco {
        private Long id;
        private String nome;
        private Integer quantidadePontos;
        private Double valorHora;
    }

    @Data
    public static class Usuario {
        private Long id;
        private String nome;
    }

}
