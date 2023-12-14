package com.rjtrip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjtrip.models.Pedido;
import com.rjtrip.services.PedidoServices;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoServices pedidoServices;
	
	@GetMapping("/listar")
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoServices.getAllPedido();
		model.addAttribute("pedidos", pedidos);
		return "testes/readTest";
	}
	
	@GetMapping("/cadastro")
	public String frmCadastroPedido(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		return "testes/savePedidoTest";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarPedido(@ModelAttribute("pedido") Pedido pedido) {
		pedidoServices.savePedido(pedido);
		return "redirect:/pedido/cadastro";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarPedido(@PathVariable Long id) {
		pedidoServices.deletePedido(id);
		return "redirect:/pedido/listar";
	}
}