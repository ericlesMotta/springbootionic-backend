package com.ericles.cursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ericles.cursomc.domain.Categoria;
import com.ericles.cursomc.domain.Pedido;
import com.ericles.cursomc.dto.CategoriaDTO;
import com.ericles.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos") //Endpoint Rest Mapeamento do Spring para caracterizar o código como um endpoint REST
public class PedidoResource {
	@Autowired
	private PedidoService pedido;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET) 
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = pedido.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
		obj = pedido.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
