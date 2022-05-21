package br.com.fgalogistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas/v1")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar (@RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Entrega> listar () {
		return service.listar();
	}
	
	
}
