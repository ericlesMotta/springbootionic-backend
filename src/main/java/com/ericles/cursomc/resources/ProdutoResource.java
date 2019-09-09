package com.ericles.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ericles.cursomc.domain.Produto;
import com.ericles.cursomc.dto.ProdutoDTO;
import com.ericles.cursomc.resources.utils.URL;
import com.ericles.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos") //Endpoint Rest Mapeamento do Spring para caracterizar o código como um endpoint REST
public class ProdutoResource {
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET) 
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = produtoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET) 
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam (value = "nome",defaultValue = "")String nome,
			@RequestParam (value = "categorias",defaultValue = "0")String categorias,

			@RequestParam (value = "page",defaultValue = "0")Integer page,
			@RequestParam (value = "linesPerPage",defaultValue = "24")Integer linesPerPage,
			@RequestParam (value = "orderBy",defaultValue = "nome")String orderBy,
			@RequestParam (value = "direction",defaultValue = "ASC")String direction) {
		
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> listIds =URL.decodeIntList(categorias);
		Page<Produto> list = produtoService.search(nomeDecoded,listIds,page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
