package br.com.rd.ved.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.rd.ved.model.PK.PedidoIntemPedidoCH;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoIntemPedidoCH idch;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", insertable = false, updatable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", insertable = false, updatable = false)
	private Produto produto;
	
	@Column(name = "quantidade_total")
	@Size(max = 50)
	private Integer quantidade;
	
	@Column(name = "porcentagem_icms")
	private Double porcentagemIcms;
	
	@Column(name = "valor_icms")
	private Double valorIcms;
	
	

	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Produto produto, @Size(max = 50) Integer quantidade, Double porcentagemIcms,
			Double valorIcms) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
	}



	public ItemPedido(Integer quantidade, Double porcentagemIcms, Double valorIcms) {
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
	}

	

	public PedidoIntemPedidoCH getIdch() {
		return idch;
	}

	public void setIdch(PedidoIntemPedidoCH idch) {
		this.idch = idch;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPorcentagemIcms() {
		return porcentagemIcms;
	}

	public void setPorcentagemIcms(Double porcentagemIcms) {
		this.porcentagemIcms = porcentagemIcms;
	}

	public Double getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}
}
