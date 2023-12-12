package com.rjtrip.services;

import java.util.List;

import com.rjtrip.models.Pacote;

public interface PacoteServices {

	List<Pacote> getAllPacote();
	
	Pacote getPacoteById(Long id);
	
	Pacote savePacote(Pacote pacote);
	
	Pacote updatePacote(Long id, Pacote pacoteUpdated);
	
	void deletePacote(Long id);
}
