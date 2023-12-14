package com.rjtrip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjtrip.models.Cliente;
import com.rjtrip.services.ClienteServices;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("/listar")
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteServices.getAllClientes();
		model.addAttribute("clientes", clientes);
		return "testes/readTest";
	}
	
	@GetMapping("/cadastro")
	public String formCadastroCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "testes/saveClienteTest.html";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServices.saveCliente(cliente);
		return "redirect:/cliente/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String formEditarCliente(@PathVariable Long id, Model model) {
		Cliente cliente = clienteServices.getClienteById(id);
		model.addAttribute("cliente", cliente);
		return "testes/editClienteTest";
	}
	
	@PostMapping("/editar/{id}")
	public String editarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
		clienteServices.updateCliente(id, cliente);
		return "redirect:/cliente/readTest";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarCliente(@PathVariable Long id) {
		clienteServices.deleteCliente(id);
		return "redirect:/cliente/readTest";
	}
}
