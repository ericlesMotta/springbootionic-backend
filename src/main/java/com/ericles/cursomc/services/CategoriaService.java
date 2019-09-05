package com.ericles.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericles.cursomc.domain.Categoria;
import com.ericles.cursomc.repositories.CategoriaRepository;
import com.ericles.cursomc.services.exceptions.ObjectNotFoundException;

@Service //Marcação do Spring para Service
public class CategoriaService {
	@Autowired //Instancia Objetos automaticamente
	private CategoriaRepository repo;
	
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
