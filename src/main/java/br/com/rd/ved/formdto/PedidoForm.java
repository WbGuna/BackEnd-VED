package br.com.rd.ved.formdto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.CupomDescontoRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.FreteRepository;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PedidoStatusRepository;

public class PedidoForm {
	
	private Date data;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Integer cliente;
	private Integer cupomDesconto;
	private Integer pedidoStatus;
	private Integer frete;
	private Integer enderecos;
	private List<ItemPedido> itemPedido;
	private String tipoPagamento;
	private BigDecimal valorTotal;


	public PedidoForm(String data, String cliente, String cupomDesconto,
			String pedidoStatus, String frete, String enderecos, String tipoPagamento, String valorTotal) throws ParseException {
		this.data = formato.parse(data);
		this.cliente = Integer.parseInt(cliente);
		this.cupomDesconto = Integer.parseInt(cupomDesconto);
		this.pedidoStatus = Integer.parseInt(pedidoStatus);
		this.frete = Integer.parseInt(frete);
		this.enderecos = Integer.parseInt(enderecos);
		this.tipoPagamento = tipoPagamento;
		this.valorTotal = new BigDecimal(valorTotal);
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public void setFormato(SimpleDateFormat formato) {
		this.formato = formato;
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
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
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


	public Pedido converter(PedidoRepository pedidoRepository, 
							ClienteRepository clienteRepository,
							CupomDescontoRepository cupomDescontoRepository,
							PedidoStatusRepository pedidoStatusRepository,
							FreteRepository freteRepository,
							EnderecoRepository enderecoRepository,
							ItemPedidoRepository itemPedidoRepository) { 
		
		Optional<Cliente> cliente = clienteRepository.findById(this.cliente);		
		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(this.cupomDesconto);
		Optional<PedidoStatus> pedidoStatus = pedidoStatusRepository.findById(this.pedidoStatus);
		Optional<Frete> frete = freteRepository.findById(this.frete);
		Optional<Endereco> endereco = enderecoRepository.findById(this.enderecos);
		List<ItemPedido> items = new ArrayList<ItemPedido>();
		items.add((ItemPedido) this.itemPedido);
		
		Pedido pedido = new Pedido(data, cliente.get(), cupomDesconto.get(), pedidoStatus.get(), frete.get(), endereco.get(), tipoPagamento, valorTotal);
				
		return pedido;

	}
	
	public List<PedidoDTO> cadastrarPedido(Pedido pedido, Cliente cliente, PedidoRepository pedidoRepository) {
		List<Pedido> pedidos;
		
		pedidos = cliente.getPedidos();
		pedidos.add(pedido);
		cliente.setPedidos(pedidos);
		pedidoRepository.save(cliente);
		return PedidoDTO.converter(pedidos);

	} 
	
}
