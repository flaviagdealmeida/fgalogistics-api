package br.com.fgalogistics.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.fgalogistics.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {
	
	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;


}
