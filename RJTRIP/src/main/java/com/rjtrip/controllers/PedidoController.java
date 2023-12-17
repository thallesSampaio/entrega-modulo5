package com.rjtrip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjtrip.models.Pedido;
import com.rjtrip.services.PedidoServices;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoServices pedidoServices;
	
	@PostMapping("/savepedido")
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidoServices.savePedido(pedido);
	}

	@GetMapping("/allpedidos")
	public List<Pedido> getAllPedidos() {
		return pedidoServices.getAllPedido();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
		Pedido pedido = pedidoServices.getPedidoById(id);
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable Long id) {
		pedidoServices.deletePedido(id);
	}
}