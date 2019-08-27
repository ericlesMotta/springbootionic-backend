package com.ericles.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericles.cursomc.domain.Estado;
import com.ericles.cursomc.domain.Produto;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}
