package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.Espaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {
}
