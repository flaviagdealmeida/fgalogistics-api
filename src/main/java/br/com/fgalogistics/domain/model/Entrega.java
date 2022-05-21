package br.com.fgalogistics.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import br.com.fgalogistics.validation.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid //para validar os dados que vem da relação com o cliente
	@ConvertGroup(from=Default.class, to=ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne //padrão para o campo ID
	private Cliente cliente;
	
	@Embedded //quando agregamos o valor de destinatario na tabela de entrega
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING) //armazena o texto da enumeração
	private StatusEntrega status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataPedido; //mostra o GMT
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
		
	
}
