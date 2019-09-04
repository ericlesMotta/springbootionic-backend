package com.ericles.cursomc.domain;

import javax.persistence.Entity;

import com.ericles.cursomc.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
