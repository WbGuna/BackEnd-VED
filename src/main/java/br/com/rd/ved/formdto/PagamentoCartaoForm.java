package br.com.rd.ved.formdto;

import java.math.BigDecimal;



public class PagamentoCartaoForm {

	
	private Integer parcela;
	
	private BigDecimal valorTotal;
	
	private BigDecimal valorParcela;


	public PagamentoCartaoForm(String parcela, String valorTotal) {
		this.parcela = Integer.parseInt(parcela);
		this.valorTotal = new BigDecimal(valorTotal);
		this.valorParcela = valorParcelas(valorTotal, parcela);
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

	public BigDecimal valorParcelas(String valorTotal, String parcelas) {
		System.out.println("entrei");
		BigDecimal parcelas1 = new BigDecimal(parcelas);
		BigDecimal total1 = new BigDecimal(valorTotal);
		BigDecimal valorParcela1 = total1.divide(parcelas1);		
		return valorParcela1;
	}
	
}
