package com.ericles.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericles.cursomc.domain.Cliente;
import com.ericles.cursomc.repositories.ClienteRepository;
import com.ericles.cursomc.services.exceptions.ObjectNotFoundException;

@Service //Marcação do Spring para Service
public class ClienteService {
	@Autowired //Instancia Objetos automaticamente
	private ClienteRepository repo;
	
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
}
