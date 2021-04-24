package com.projetosoftware2.resercoworking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetosoftware2.resercoworking.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository <Pais, Long>  {

}
