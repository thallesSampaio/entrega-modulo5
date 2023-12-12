package com.rjtrip.services;

import java.util.List;

import com.rjtrip.models.Cliente;

public interface ClienteServices {
	
	List<Cliente> getAllClientes();
	
	Cliente getClienteById(Long id);
	
	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Long id, Cliente clienteUpdated);
	
	void deleteCliente(Long id);
}
