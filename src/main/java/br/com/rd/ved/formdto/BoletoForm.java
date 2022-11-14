package br.com.rd.ved.formdto;

import br.com.rd.ved.model.Boleto;
import br.com.rd.ved.repository.BoletoRepository;

public class BoletoForm {


	private String codigoBarras;
	private String nome;
	private String cpf;

	public BoletoForm(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.codigoBarras = "34191.79001 01043.510047 91020.150008 7 89250026000";
	}

	
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boleto converter(BoletoRepository boletoRepository) {
		
	return new Boleto("34191.79001 01043.510047 91020.150008 7 89250026000",nome,cpf);
		
	}

}
