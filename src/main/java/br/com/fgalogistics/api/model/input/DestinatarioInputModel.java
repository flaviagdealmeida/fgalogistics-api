package br.com.fgalogistics.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioInputModel {
	
	@NotBlank
	private String nome;	
	
	@NotBlank
	private String logradouro;	
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;	
	
	@NotBlank
	private String bairro;
	

}
