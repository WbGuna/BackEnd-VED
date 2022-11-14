package br.com.rd.ved.formdto;

import java.util.List;
import java.util.Optional;

import br.com.rd.ved.dto.HistoricoPagamentoDTO;
import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.model.Boleto;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.HistoricoPagamento;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Pix;
import br.com.rd.ved.repository.BoletoRepository;
import br.com.rd.ved.repository.CartaoRepository;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.HistoricoPagamentoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PixRepository;

public class HistoricoPagamentoForm {

	private Integer pedido;
	private Integer cliente;
	private Integer pix;
	private Integer boleto;
	private Integer cartao;
	private String statusPagamento;

	public HistoricoPagamentoForm(String pedido, String cliente, String pix, String boleto, String cartao,
			String statusPagamento) {
		super();
		this.pedido = Integer.parseInt(pedido);
		this.cliente = Integer.parseInt(cliente);
		this.pix = Integer.parseInt(pix);
		this.boleto = Integer.parseInt(boleto);
		this.cartao = Integer.parseInt(cartao);
		this.statusPagamento = statusPagamento;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getPix() {
		return pix;
	}

	public void setPix(Integer pix) {
		this.pix = pix;
	}

	public Integer getBoleto() {
		return boleto;
	}

	public void setBoleto(Integer boleto) {
		this.boleto = boleto;
	}

	public Integer getCartao() {
		return cartao;
	}

	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public HistoricoPagamento converter(PedidoRepository pedidoRepository, ClienteRepository clienteRepository,
							PixRepository pixRepository, BoletoRepository boletoRepository,
							CartaoRepository cartaoRepository) {

		Optional<Pedido> pedido = pedidoRepository.findById(this.pedido);
		Optional<Cliente> cliente = clienteRepository.findById(this.cliente);
		Optional<Pix> pix = pixRepository.findById(this.pix);
		Optional<Boleto> boleto = boletoRepository.findById(this.boleto);
		Optional<Cartao> cartao = cartaoRepository.findById(this.cartao);

		HistoricoPagamento historico = new HistoricoPagamento(pedido.get(), cliente.get(), pix.get(),boleto.get(),cartao.get(), statusPagamento);

		return historico;

	}
	
	public List<HistoricoPagamentoDTO> cadastrarHistorico(HistoricoPagamento historicoPagamento, Pedido pedido, HistoricoPagamentoRepository historicoPedidoRepository) {
		List<HistoricoPagamento> historico;
		
		historico = pedido.getHistoricoPagamento();
		historico.add(historicoPagamento);
		pedido.setHistoricoPagamento(historico);
		historicoPedidoRepository.save(pedido);
		return HistoricoPagamentoDTO.converter(historico);
	} 
}
