package com.rjtrip.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjtrip.models.Mensagem;
import com.rjtrip.repositories.MensagemRepository;
import com.rjtrip.services.MensagemServices;

@Service
public class MensagemServicesImpl implements MensagemServices {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Override
	public List<Mensagem> getAllMensagem() {
		return mensagemRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mensagem getMensagemById(Long id) {
		return mensagemRepository.findById(id).orElse(null);
	}

	@Override
	public Mensagem saveMensagem(Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}

	@Override
	public void deleteMensagem(Long id) {
		mensagemRepository.deleteById(id);
	}
}
