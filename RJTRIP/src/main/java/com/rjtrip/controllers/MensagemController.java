package com.rjtrip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.rjtrip.models.Mensagem;
import com.rjtrip.services.MensagemServices;

@Controller
public class MensagemController {

	@Autowired
	MensagemServices mensagemServices;
	
	@GetMapping("/listar")
	public String listarMensagens(Model model) {
		List<Mensagem> mensagens = mensagemServices.getAllMensagem();
		model.addAttribute("mensagens", mensagens);
		return "testes/readTest";
	}
	
	@GetMapping("/contato") 
	public String frmContato(Model model) {
		Mensagem mensagem = new Mensagem();
		model.addAttribute("mensagem", mensagem);
		return "testes/saveMsgTest";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarMensagem(@ModelAttribute("mensagem") Mensagem mensagem) {
		mensagemServices.saveMensagem(mensagem);
		return "redirect:/contato";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarMensagem(@PathVariable Long id) {
		mensagemServices.deleteMensagem(id);
		return "redirect:/listar";
	}
}
