package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.ReservaEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaEsparcoRepository extends JpaRepository<ReservaEspaco, Long> {
}
