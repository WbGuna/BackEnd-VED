package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.PK.PedidoIntemPedidoCH;

public class ItemPedidoDTO {

	private Integer Quantidade;
	private PedidoIntemPedidoCH chave;
	
	
		
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.chave = itemPedido.getIdch();
		this.Quantidade = itemPedido.getQuantidade();
	}


	public Integer getQuantidade() {
		return Quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

	public void setChave(PedidoIntemPedidoCH chave) {
		this.chave = chave;
	}
	

	public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
		return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}
	
}