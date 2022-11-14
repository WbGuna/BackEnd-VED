package br.com.rd.ved.formdto;



public class ItemPedidoForm {

	private String quantidade;
	private String porcentagemIcms;
	private String valorIcms;
	private String produto;
	private String pedido;
	
	public ItemPedidoForm() {}
	

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPorcentagemIcms() {
		return porcentagemIcms;
	}

	public void setPorcentagemIcms(String porcentagemIcms) {
		this.porcentagemIcms = porcentagemIcms;
	}

	public String getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(String valorIcms) {
		this.valorIcms = valorIcms;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

}
