package com.ericles.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias") //Endpoint Rest
public class CategoriaResource {
	@RequestMapping(method=RequestMethod.GET)
	public String Listar() {
		return "Rest está funcionando!";
	}
}
