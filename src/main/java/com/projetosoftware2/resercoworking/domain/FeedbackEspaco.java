package com.projetosoftware2.resercoworking.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.projetosoftware2.resercoworking.domain.dto.FeedbackEspacoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback_espaco")
public class FeedbackEspaco implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(name = "ds_feedback", length = 500)
    private String dsfeedback;
    
    @Column(name = "nota_feedback", nullable = false)
    private Integer notafeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reserva_espaco")
    private ReservaEspaco reservaEspaco;
}
