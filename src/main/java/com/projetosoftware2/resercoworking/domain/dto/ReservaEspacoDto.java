package com.projetosoftware2.resercoworking.domain.dto;

import com.projetosoftware2.resercoworking.domain.enums.FormaPagamento;
import com.projetosoftware2.resercoworking.domain.enums.SituacaoReservaEspaco;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEspacoDto {

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDateTime horaInicial;
    private LocalDateTime horaFinal;
    private FormaPagamento formaPagamento;
    private Double valorTotal;
    private Integer quantidadePontosTotal;
    private Espaco espaco;
    private Usuario usuarioReservou;
    private SituacaoReservaEspaco situacaoReservaEspaco;

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
