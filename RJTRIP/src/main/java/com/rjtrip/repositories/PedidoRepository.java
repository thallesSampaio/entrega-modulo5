package com.rjtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rjtrip.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
