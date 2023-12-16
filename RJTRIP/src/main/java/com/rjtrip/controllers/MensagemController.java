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

import com.rjtrip.models.Mensagem;
import com.rjtrip.services.MensagemServices;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

	@Autowired
	MensagemServices mensagemServices;
	
	@PostMapping("/savemensagem")
	public Mensagem createMensagem(@RequestBody Mensagem mensagem) {
		return mensagemServices.saveMensagem(mensagem);
	}

	@GetMapping("/allmensagens")
	public List<Mensagem> getAllMensagens() {
		return mensagemServices.getAllMensagem();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mensagem> getMensagemById(@PathVariable Long id) {
		Mensagem mensagem = mensagemServices.getMensagemById(id);
		return ResponseEntity.ok(mensagem);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMensagem(@PathVariable Long id) {
		mensagemServices.deleteMensagem(id);
	}
}