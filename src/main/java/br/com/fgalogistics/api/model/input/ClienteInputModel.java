package br.com.fgalogistics.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInputModel {
	
	@NotNull
	private Long id;
	

}
