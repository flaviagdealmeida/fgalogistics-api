package br.com.fgalogistics.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputModel {

	@Valid
	@NotNull
	private ClienteInputModel cliente;
	
	@Valid
	@NotNull
	private DestinatarioInputModel destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
}
