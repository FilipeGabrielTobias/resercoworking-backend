package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.Premiacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiacaoRepository extends JpaRepository<Premiacao, Long> {
}
