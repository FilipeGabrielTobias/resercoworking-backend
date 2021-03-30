package com.projetosoftware2.resercoworking.dto;

import com.projetosoftware2.resercoworking.domain.FormaPagamento;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaEspacoDto {

    private LocalDate dataInicial;

    private LocalDate dataFinal;

    private LocalTime horaInicial;

    private LocalTime horaFinal;

    private FormaPagamento formaPagamento;

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
