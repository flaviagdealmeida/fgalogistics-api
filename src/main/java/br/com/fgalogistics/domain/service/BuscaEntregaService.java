package br.com.fgalogistics.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fgalogistics.domain.exception.ResourceNotFoundException;
import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new ResourceNotFoundException("Entrega não encontrada"));
	}
}
