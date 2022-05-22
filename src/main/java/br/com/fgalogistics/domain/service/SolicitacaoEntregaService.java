package br.com.fgalogistics.domain.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fgalogistics.api.assembler.EntregaAssembler;
import br.com.fgalogistics.api.model.EntregaModel;
import br.com.fgalogistics.api.model.input.EntregaInputModel;
import br.com.fgalogistics.domain.model.Cliente;
import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.domain.model.StatusEntrega;
import br.com.fgalogistics.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private EntregaRepository repository;
	
	@Autowired
	private EntregaAssembler entregaAssembler;
	
	@Autowired
	private ClienteService service;

	public EntregaModel solicitar(EntregaInputModel entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Cliente cliente = service.findById(novaEntrega.getCliente().getId());
		
		novaEntrega.setCliente(cliente);
		novaEntrega.setStatus(StatusEntrega.PENDENTE);
		novaEntrega.setDataPedido(OffsetDateTime.now());

		return entregaAssembler.toModel(repository.save(novaEntrega));
	}

	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(repository.findAll());
	}

	public ResponseEntity<EntregaModel> buscar (Long id) {
		return repository.findById(id)	.map(entrega -> {
			return ResponseEntity.ok(entregaAssembler.toModel(entrega));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
}
