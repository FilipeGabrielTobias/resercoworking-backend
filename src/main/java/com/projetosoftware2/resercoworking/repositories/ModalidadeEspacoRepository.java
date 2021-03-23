package com.projetosoftware2.resercoworking.repositories;

import com.projetosoftware2.resercoworking.domain.ModalidadeEspaco;
import com.projetosoftware2.resercoworking.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalidadeEspacoRepository extends JpaRepository<ModalidadeEspaco, Long>{
   ModalidadeEspaco findByNome(String nome);
}

