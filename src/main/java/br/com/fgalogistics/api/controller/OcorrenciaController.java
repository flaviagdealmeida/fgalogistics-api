package br.com.fgalogistics.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fgalogistics.api.assembler.OcorrenciaAssembler;
import br.com.fgalogistics.api.model.OcorrenciaModel;
import br.com.fgalogistics.api.model.input.OcorrenciaInputModel;
import br.com.fgalogistics.domain.model.Entrega;
import br.com.fgalogistics.domain.model.Ocorrencia;
import br.com.fgalogistics.domain.service.BuscaEntregaService;
import br.com.fgalogistics.domain.service.RegistroOcorrenciasService;

@RestController
@RequestMapping("/entregas/v1/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	RegistroOcorrenciasService ocorrenciaService;
	
	@Autowired
	OcorrenciaAssembler ocorrenciaAssembler;
	
	@Autowired
	BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInputModel ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}

}
