package br.com.rd.ved.dto;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Pedido;
public class PedidoDTO {
	private Integer id;
//	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Date data;	
	private Integer cliente;
	private Integer cupomDesconto;
	private Integer pedidoStatus;
	private Integer frete;
	private Integer enderecos;
	private String tipoPagamento;
	private BigDecimal valorTotal;
	
	public PedidoDTO(Pedido pedido) {	
		this.id = pedido.getId();
		this.data = pedido.getData();
		this.cliente = pedido.getCliente().getId();
		this.cupomDesconto = pedido.getCupomDesconto().getId();
		this.pedidoStatus = pedido.getPedidoStatus().getId();
		this.frete = pedido.getFrete().getId();
		this.enderecos = pedido.getEnderecos().getId();
		this.tipoPagamento = pedido.getTipoPagamento();
		this.valorTotal = pedido.getValorTotal();
	}
	
	
	public String getData() { 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoje = formato.format(data); 
		return hoje ; 
	} 

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(Integer cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	
	public Integer getId() {
		return id;
	}


	public Integer getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(Integer pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public Integer getFrete() {
		return frete;
	}

	public void setFrete(Integer frete) {
		this.frete = frete;
	}

	public Integer getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Integer enderecos) {
		this.enderecos = enderecos;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}
