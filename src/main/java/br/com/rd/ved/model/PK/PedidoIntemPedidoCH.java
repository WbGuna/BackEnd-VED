package br.com.rd.ved.model.PK;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoIntemPedidoCH implements Serializable {
	private static final long serialVersionUID = 1L;
		
	
	@Column(name = "id_pedido")
	private Integer pedido;
		
	@Column(name = "id_produto")
	private Integer produto;
	
	public PedidoIntemPedidoCH() {}
	
	public PedidoIntemPedidoCH(Integer pedido, Integer produto) {
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoIntemPedidoCH other = (PedidoIntemPedidoCH) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}
	
	
}
