package br.com.fgalogistics.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInputModel {

	@NotBlank
	private String descricao;
}
