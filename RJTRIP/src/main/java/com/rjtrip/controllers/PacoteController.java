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
import com.rjtrip.models.Pacote;
import com.rjtrip.services.PacoteServices;

@RestController
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
	private PacoteServices pacoteServices;
	
	@PostMapping("/savepacote")
	public Pacote createPacote(@RequestBody Pacote pacote) {
		return pacoteServices.savePacote(pacote);
	}
	
	@GetMapping("/allpacote")
	public List<Pacote> getAllPacote() {
		return pacoteServices.getAllPacote();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
		Pacote pacote = pacoteServices.getPacoteById(id);
		return ResponseEntity.ok(pacote);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteUpdated) {
		Pacote pacoteExistente = pacoteServices.getPacoteById(id);
		pacoteExistente.setNome(pacoteUpdated.getNome());
		pacoteExistente.setDuracao(pacoteUpdated.getDuracao());
		pacoteExistente.setPreco(pacoteUpdated.getPreco());
		pacoteServices.savePacote(pacoteExistente);
		return ResponseEntity.ok(pacoteExistente);
	}
	
	@DeleteMapping("/{id}")
	public void deletePacote(@PathVariable Long id) {
		pacoteServices.deletePacote(id);
	}
}
