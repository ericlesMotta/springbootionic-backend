package com.ericles.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
