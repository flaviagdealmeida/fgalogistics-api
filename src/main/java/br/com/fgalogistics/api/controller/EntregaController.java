package br.com.fgalogistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fgalogistics.api.model.EntregaModel;
import br.com.fgalogistics.api.model.input.EntregaInputModel;
import br.com.fgalogistics.domain.service.FinalizacaoEntregaService;
import br.com.fgalogistics.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas/v1")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService service;
	
	@Autowired
	private FinalizacaoEntregaService finalizacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar (@Valid @RequestBody EntregaInputModel entregaInput) {
		return service.solicitar(entregaInput);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<EntregaModel> listar () {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EntregaModel> buscar (@PathVariable Long id) {
		return service.buscar(id);
	}
	
	@PutMapping("/{id}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		finalizacaoService.finalizar(id);
	}
	
}
