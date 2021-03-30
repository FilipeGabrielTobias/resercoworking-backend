package com.projetosoftware2.resercoworking.domain;

import com.projetosoftware2.resercoworking.dto.ReservaEspacoCancelamentoDto;
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
@Table(name = "reserva_espaco_cancelamento")
public class ReservaEspacoCancelamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_cancelamento", nullable = false)
    private LocalDate dataCancelamento = LocalDate.now();

    @Column(name = "hora_cancelamento", nullable = false)
    private LocalTime horaCancelamento = LocalTime.now();

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "fk_reserva_espaco", nullable = false)
    private ReservaEspaco reservaEspaco;

    public ReservaEspacoCancelamento(ReservaEspacoCancelamentoDto dto) {
        this.motivo = dto.getMotivo();
        ReservaEspaco reservaEspaco = new ReservaEspaco();
        reservaEspaco.setId(dto.getReservaEspaco().getId());
        this.reservaEspaco = reservaEspaco;
    }
}
