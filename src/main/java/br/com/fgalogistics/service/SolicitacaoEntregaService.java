package br.com.fgalogistics.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fgalogistics.domain.model.Cliente;
import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.domain.model.StatusEntrega;
import br.com.fgalogistics.dto.EntregaDTO;
import br.com.fgalogistics.exception.ResourceNotFoundException;
import br.com.fgalogistics.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private ClienteService service;

	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = service.findById(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return repository.save(entrega);
	}

	public List<Entrega> listar() {
		return repository.findAll();
	}

	public Entrega buscar (Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
	}
	
	
}
