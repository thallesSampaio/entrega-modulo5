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
import com.rjtrip.services.ClienteServices;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServices clienteServices;
	
	@PostMapping("/savecliente")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteServices.saveCliente(cliente);
	}
	
	@GetMapping("/allclientes")
	public List<Cliente> getAllClientes() {
		return clienteServices.getAllClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteServices.getClienteById(id);
		return ResponseEntity.ok(cliente);
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
	public void deleteCliente(@PathVariable Long id) {
		clienteServices.deleteCliente(id);
	}
}
