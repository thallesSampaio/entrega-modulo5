package com.rjtrip.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjtrip.models.Pedido;
import com.rjtrip.repositories.PedidoRepository;
import com.rjtrip.services.PedidoServices;

@Service
public class PedidoServicesImpl implements PedidoServices {

	PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> getAllPedido() {
		return pedidoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido getPedidoById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public void deletePedido(Long id) {
		pedidoRepository.deleteById(id);
	}
}
