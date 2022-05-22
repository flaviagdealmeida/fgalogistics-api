package br.com.fgalogistics.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciasService {
	
	@Autowired
	private BuscaEntregaService buscaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega= buscaService.buscar(entregaId);
		return entrega.addOcorrencia(descricao);
	}
	
}
