package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}
