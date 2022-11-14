package br.com.rd.ved.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico_pagamento")
public class HistoricoPagamento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historico")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	
	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="id_pix", nullable = true)
	private Pix pix;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_boleto", nullable = true)
	private Boleto boleto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cartao", nullable = true)
	private Cartao cartao;
	
	private String statusPagamento;

	public HistoricoPagamento() {}

	public HistoricoPagamento(Pedido pedido, Cliente cliente, Pix pix, Boleto boleto, Cartao cartao,
			String statusPagamento) {
		this.pedido = pedido;
		this.cliente = cliente;
		this.pix = pix;
		this.boleto = boleto;
		this.cartao = cartao;
		this.statusPagamento = statusPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pix getPix() {
		return pix;
	}

	public void setPix(Pix pix) {
		this.pix = pix;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoPagamento other = (HistoricoPagamento) obj;
		return Objects.equals(id, other.id);
	}
	
}
