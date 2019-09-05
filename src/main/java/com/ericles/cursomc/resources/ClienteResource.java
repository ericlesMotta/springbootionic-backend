package com.ericles.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ericles.cursomc.domain.Cliente;
import com.ericles.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes") //Endpoint Rest Mapeamento do Spring para caracterizar o código como um endpoint REST
public class ClienteResource {
	@Autowired
	private ClienteService cliente;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET) 
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = cliente.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
