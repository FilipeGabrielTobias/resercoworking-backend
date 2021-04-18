package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.dto.ReservaEspacoDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalTime horaInicial;

    @Column(name = "hora_final", nullable = false)
    private LocalTime horaFinal;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_reserva_espaco", nullable = false)
    private SituacaoReservaEspaco situacaoReservaEspaco = SituacaoReservaEspaco.AGENDADO;

    @ManyToOne
    @JoinColumn(name = "fk_espaco", nullable = false)
    private Espaco espaco;

    @ManyToOne
    @JoinColumn(name = "fk_usuario_reservou", nullable = false)
    private Usuario usuarioReservou;
    
    @OneToOne
    @JoinColumn(name = "fk_feedback", nullable = true)
    private FeedBackEspaco feedBackEspaco;

    public ReservaEspaco(ReservaEspacoDto dto) {
        this.dataInicial = dto.getDataInicial();
        this.dataFinal = dto.getDataFinal();
        this.horaInicial = dto.getHoraInicial();
        this.horaFinal = dto.getHoraFinal();
        this.formaPagamento = dto.getFormaPagamento();
        Espaco espaco = new Espaco();
        espaco.setId(dto.getEspaco().getId());
        this.espaco = espaco;
        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioReservou().getId());
        this.usuarioReservou = usuario;
    }
}
