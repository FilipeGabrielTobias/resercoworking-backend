package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.domain.enums.FormaPagamento;
import com.projetosoftware2.resercoworking.domain.enums.SituacaoReservaEspaco;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "reserva_espaco")
public class ReservaEspaco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate dataInicial;

    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "hora_inicial", nullable = false)
    private LocalDateTime horaInicial;

    @Column(name = "hora_final", nullable = false)
    private LocalDateTime horaFinal;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;
    
    @Column(name = "quantidade_pontos_total", nullable = false)
    private Integer quantidadePontosTotal;
         
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_reserva_espaco", nullable = false)
    private SituacaoReservaEspaco situacaoReservaEspaco = SituacaoReservaEspaco.RESERVADO;

    @ManyToOne
    @JoinColumn(name = "fk_espaco", nullable = false)
    private Espaco espaco;

    @ManyToOne
    @JoinColumn(name = "fk_usuario_reservou", nullable = false)
    private Usuario usuarioReservou;
}
