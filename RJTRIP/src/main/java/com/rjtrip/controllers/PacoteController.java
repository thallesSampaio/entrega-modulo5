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

import com.rjtrip.models.Pacote;
import com.rjtrip.services.PacoteServices;

@Controller
@RequestMapping("/admin")
public class PacoteController {

	@Autowired
	private PacoteServices pacoteServices;
	
	@GetMapping("/listar")
	public String listarPacotes(Model model) {
		List<Pacote> pacotes = pacoteServices.getAllPacote();
		model.addAttribute("pacotes", pacotes);
		return "testes/readTest";
	}
	
	@GetMapping("/cadastro")
	public String frmCadastroPacote(Model model) {
		Pacote pacote = new Pacote();
		model.addAttribute("pacote", pacote);
		return "testes/savePacoteTest";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarPacote(@ModelAttribute("pacote") Pacote pacote) {
		pacoteServices.savePacote(pacote);
		return "redirect:/admin/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String frmEditarPacote(@PathVariable Long id, Model model) {
		Pacote pacote = pacoteServices.getPacoteById(id);
		model.addAttribute("pacote", pacote);
		return "testes/editPacoteTest";
	}
	
	@PostMapping("/editar/{id}")
	public String editarPacote(@PathVariable Long id, @ModelAttribute("pacote") Pacote pacote) {
		pacoteServices.updatePacote(id, pacote);
		return "redirect:/admin/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarPacote(@PathVariable Long id) {
		pacoteServices.deletePacote(id);
		return "redirect:/testes/readTest";
	}
	
}
