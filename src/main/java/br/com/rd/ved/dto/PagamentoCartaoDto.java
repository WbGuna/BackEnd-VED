package br.com.rd.ved.dto;

import java.math.BigDecimal;

import br.com.rd.ved.formdto.PagamentoCartaoForm;
import br.com.rd.ved.model.Cartao;

public class PagamentoCartaoDto {

	private Integer parcela;

	private BigDecimal valorTotal;

	private BigDecimal valorParcela;
	
	private Cartao cartao;
	
	private Integer numeroPedido;

	public PagamentoCartaoDto() {
	}

	public PagamentoCartaoDto(PagamentoCartaoForm form, Cartao cartao, Integer numeroPedido) {
		this.parcela = form.getParcela();
		this.valorTotal = form.getValorTotal();
		this.valorParcela = form.getValorParcela();
		this.cartao = cartao;
		this.numeroPedido = numeroPedido;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public BigDecimal valorParcelas(BigDecimal ValorTotal, Integer parcelas) {
		
		BigDecimal parcelas1 = new BigDecimal(parcelas);
		BigDecimal valorParcela1 = ValorTotal.divide(parcelas1);
		
		System.out.println(valorParcela1);
		
		return valorParcela1;
	}

}
