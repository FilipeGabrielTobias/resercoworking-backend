package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
