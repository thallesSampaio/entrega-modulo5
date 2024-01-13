package com.rjtrip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjtrip.models.Cliente;
import com.rjtrip.models.Pedido;
import com.rjtrip.services.ClienteServices;
import com.rjtrip.services.PedidoServices;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoServices pedidoServices;
	
	@Autowired
	ClienteServices clienteServices;
	
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoUpdated) {
		Pedido pedidoExistente = pedidoServices.getPedidoById(id);
		pedidoExistente.setDataViagem(pedidoUpdated.getDataViagem());
		pedidoExistente.setDestinos(pedidoUpdated.getDestinos());
		pedidoExistente.setCliente(pedidoUpdated.getCliente());
		pedidoExistente.setPacote(pedidoUpdated.getPacote());
		return ResponseEntity.ok(pedidoExistente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteUpdated) {
		Cliente clienteExistente = clienteServices.getClienteById(id);
		clienteExistente.setNome(clienteUpdated.getNome());
		clienteExistente.setCpf(clienteUpdated.getCpf());
		clienteExistente.setEmail(clienteUpdated.getEmail());
		clienteExistente.setDataNascimento(clienteUpdated.getDataNascimento());
		clienteExistente.setEndereco(clienteUpdated.getEndereco());
		clienteServices.saveCliente(clienteExistente);
		return ResponseEntity.ok(clienteExistente);
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable Long id) {
		pedidoServices.deletePedido(id);
	}
}