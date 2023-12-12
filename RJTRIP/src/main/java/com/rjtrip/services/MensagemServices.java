package com.rjtrip.services;

import java.util.List;

import com.rjtrip.models.Mensagem;

public interface MensagemServices {
	
	List<Mensagem> getAllMensagem();
	
	Mensagem getMensagemById(Long id);
	
	Mensagem saveMensagem(Mensagem mensagem);
	
	void deleteMensagem(Long id);
}
