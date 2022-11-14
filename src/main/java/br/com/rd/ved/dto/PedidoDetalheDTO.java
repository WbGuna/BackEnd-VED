package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;

public class PedidoDetalheDTO {

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Integer codigo_pedido;
	private Date data;	
	private String cliente_nome;
	private String cupomDesconto;
	private String pedidoStatus;
	private Integer codigo_frete;
	private String tipoFrete;
	private BigDecimal valor_frete;
	private Endereco enderecos;
	private String tipoPagamento;
	private List<ItemPedido> items;
	private BigDecimal total;

	public PedidoDetalheDTO(Pedido pedido) {
		this.codigo_pedido = pedido.getId();
		this.data = pedido.getData();
		this.cliente_nome = pedido.getCliente().getNome();
		this.cupomDesconto = pedido.getCupomDesconto().getDescricao();
		this.pedidoStatus = pedido.getPedidoStatus().getDescricao();
		this.codigo_frete = pedido.getFrete().getId();
		this.tipoFrete = pedido.getFrete().getTipoFrete().getDescricao();
		this.valor_frete = pedido.getFrete().getValor();
		this.enderecos = pedido.getEnderecos();
		this.tipoPagamento = pedido.getTipoPagamento();
		this.items = pedido.getItemPedidos();
		this.total = pedido.getValorTotal();
	}
	
	public Integer getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(Integer codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public String getData() { 
		String hoje = formato.format(data); 
		return hoje ; 
	} 

	public void setData(Date data) {
		this.data = data;
	}

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public String getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(String cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public String getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(String pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public Integer getCodigo_frete() {
		return codigo_frete;
	}

	public void setCodigo_frete(Integer codigo_frete) {
		this.codigo_frete = codigo_frete;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public BigDecimal getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(BigDecimal valor_frete) {
		this.valor_frete = valor_frete;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public List<ItemPedidoDetalheDTO> getItems() {
		List<ItemPedidoDetalheDTO> nova = ItemPedidoDetalheDTO.converter(items);
		return nova;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	public static List<PedidoDetalheDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDetalheDTO::new).collect(Collectors.toList());
	}
}