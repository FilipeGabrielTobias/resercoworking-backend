package com.projetosoftware2.resercoworking.dto;

import lombok.Data;

@Data
public class ReservaEspacoCancelamentoDto {
    private String motivo;
    private ReservaEspaco reservaEspaco;

    @Data
    public static class ReservaEspaco {
        private Long id;
    }
}
