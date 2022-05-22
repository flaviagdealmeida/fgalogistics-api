package br.com.fgalogistics.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fgalogistics.domain.exception.ResourceNotFoundException;
import br.com.fgalogistics.domain.model.Cliente;
import br.com.fgalogistics.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository repository;
	
	
	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}
		
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Cliente entity = repository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Registro não encontrado")
				);
		return entity;
	}
	
	public void delete(Long id) {
		Cliente entity = findById(id);
		repository.delete(entity);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente entity = findById(cliente.getId());
		
		entity.setNome(cliente.getNome());
		entity.setEmail(cliente.getEmail());
		entity.setTelefone(cliente.getTelefone());
	
		return repository.save(entity);
		
	}
	
		
	
	
	
	
	
	

}
