package br.com.rd.ved.model;

public enum FormaPagamentoEnum {

	PIX("pix"),
	BOLETO("boleto"),
	CARTAO("cartao");
		
	private String OPCAO;
	
	private FormaPagamentoEnum(String opcao) {
		this.OPCAO = opcao;
	}

	public String getOpcao() {
		return OPCAO;
	}
}
