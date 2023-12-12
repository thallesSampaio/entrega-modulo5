package com.rjtrip.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjtrip.models.Cliente;
import com.rjtrip.repositories.ClienteRepository;
import com.rjtrip.services.ClienteServices;

@Service
public class ClienteServicesImpl implements ClienteServices {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente updateCliente(Long id, Cliente clienteUpdated) {
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		if(clienteExistente != null) {
			clienteExistente.setNome(clienteUpdated.getNome());
			clienteExistente.setCpf(clienteUpdated.getCpf());
			clienteExistente.setDataNascimento(clienteUpdated.getDataNascimento());
			clienteExistente.setEndereco(clienteUpdated.getEndereco());
			return clienteRepository.save(clienteExistente);
		} else {
			throw new RuntimeException("Cliente com o ID " + id + "não encontrado.");
		}
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}

}
