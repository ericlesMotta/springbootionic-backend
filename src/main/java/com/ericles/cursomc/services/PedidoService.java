package com.ericles.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericles.cursomc.domain.Pedido;
import com.ericles.cursomc.repositories.PedidoRepository;
import com.ericles.cursomc.services.exceptions.ObjectNotFoundException;

@Service //Marcação do Spring para Service
public class PedidoService {
	@Autowired //Instancia Objetos automaticamente
	private PedidoRepository repo;
	
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
}
