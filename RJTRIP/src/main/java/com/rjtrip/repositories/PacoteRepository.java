package com.rjtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rjtrip.models.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long>{

}
