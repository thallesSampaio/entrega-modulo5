package com.rjtrip.services;

import java.util.List;

import com.rjtrip.models.Pedido;

public interface PedidoServices {
	
	List<Pedido> getAllPedido();
	
	Pedido getPedidoById(Long id);
	
	Pedido savePedido(Pedido pedido); //talvez nao funcione adequadamente
	
	void deletePedido(Long id);
}
