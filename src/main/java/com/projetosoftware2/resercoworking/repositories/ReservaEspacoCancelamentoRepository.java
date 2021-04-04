package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import com.projetosoftware2.resercoworking.domain.ReservaEspacoCancelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaEspacoCancelamentoRepository extends JpaRepository<ReservaEspacoCancelamento, Long> {
}
