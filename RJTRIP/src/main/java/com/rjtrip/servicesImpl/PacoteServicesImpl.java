package com.rjtrip.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjtrip.models.Pacote;
import com.rjtrip.repositories.PacoteRepository;
import com.rjtrip.services.PacoteServices;

@Service
public class PacoteServicesImpl implements PacoteServices {

	@Autowired
	PacoteRepository pacoteRepository;

	@Override
	public List<Pacote> getAllPacote() {
		return pacoteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pacote getPacoteById(Long id) {
		return pacoteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pacote savePacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	@Override
	public Pacote updatePacote(Long id, Pacote pacoteUpdated) {
		Pacote pacoteExistente = pacoteRepository.findById(id).orElse(null);
		if(pacoteExistente != null) {
			pacoteExistente.setNome(pacoteUpdated.getNome());
			pacoteExistente.setDuracao(pacoteUpdated.getDuracao());
			pacoteExistente.setPreco(pacoteUpdated.getPreco());
			return pacoteRepository.save(pacoteExistente);
		} else {
			throw new RuntimeException("Pacote com o ID " + id + "não encontrado.");
		}
	}

	@Override
	public void deletePacote(Long id) {
		pacoteRepository.deleteById(id);
	}
}
