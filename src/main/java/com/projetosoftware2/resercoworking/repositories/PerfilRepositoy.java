package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositoy extends JpaRepository<Perfil, Long> {
}
