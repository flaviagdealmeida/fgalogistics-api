package br.com.fgalogistics.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fgalogistics.api.model.OcorrenciaModel;
import br.com.fgalogistics.api.model.input.OcorrenciaInputModel;
import br.com.fgalogistics.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
	
private ModelMapper modelMapper;
	
	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
	}
	
	public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia>ocorrencia){
		return ocorrencia.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Ocorrencia toEntity(OcorrenciaInputModel ocorrenciaInput) {
		return modelMapper.map(ocorrenciaInput, Ocorrencia.class);
	}

}
