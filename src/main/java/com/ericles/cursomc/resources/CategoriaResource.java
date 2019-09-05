package com.ericles.cursomc.resources;

import java.net.URI;
import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ericles.cursomc.domain.Categoria;
import com.ericles.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias") //Endpoint Rest Mapeamento do Spring para caracterizar o código como um endpoint REST
public class CategoriaResource {
	@Autowired
	private CategoriaService categoria;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET) 
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = categoria.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = categoria.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
