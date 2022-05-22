package br.com.fgalogistics.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import br.com.fgalogistics.domain.validation.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
	
	
	@NotNull(groups = ValidationGroups.ClienteId.class) // 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max=255)
	private String email;
	
	@NotBlank
	@Size(max=20)
	private String telefone;

}
