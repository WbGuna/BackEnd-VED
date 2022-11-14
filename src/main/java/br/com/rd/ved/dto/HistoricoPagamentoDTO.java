package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.HistoricoPagamento;

public class HistoricoPagamentoDTO {
	
	private Integer pedido;
	private Integer cliente;
	private Integer pix;
	private Integer boleto;
	private Integer cartao;
	private String statusPagamento;
	
	public HistoricoPagamentoDTO(HistoricoPagamento historico) {
		this.pedido = historico.getPedido().getId();
		this.cliente = historico.getCliente().getId();
		this.pix = historico.getPix().getId();
		this.boleto = historico.getBoleto().getId();
		this.cartao = historico.getCartao().getId();
		this.statusPagamento = historico.getStatusPagamento();
	}

	public Integer getPedido() {
		return pedido;
	}

	public Integer getCliente() {
		return cliente;
	}

	public Integer getPix() {
		return pix;
	}

	public Integer getBoleto() {
		return boleto;
	}

	public Integer getCartao() {
		return cartao;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}
	
	public static List<HistoricoPagamentoDTO> converter(List<HistoricoPagamento> historicos) {
		return historicos.stream().map(HistoricoPagamentoDTO::new).collect(Collectors.toList());
	}
}
