package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.FeedbackEspaco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackEspacoRepository extends JpaRepository<FeedbackEspaco, Long> {

    List<FeedbackEspaco> findAllByReservaEspacoId(Long id);
}
