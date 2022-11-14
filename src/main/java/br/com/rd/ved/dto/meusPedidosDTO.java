package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Pedido;

public class meusPedidosDTO {

	private Integer id;
	private String status;

	public meusPedidosDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.status = pedido.getPedidoStatus().getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public String getStatus() {
		return status;
	} 
	
	public static List<meusPedidosDTO> converter(List<Pedido> pedidos){
		return pedidos.stream().map(meusPedidosDTO::new).collect(Collectors.toList());
	} 
}
