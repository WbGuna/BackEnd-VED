package br.com.rd.ved.dto;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Uf;

public class ClienteEnderecoDTO {

	private String cep;
	private String rua;
	private Integer numero;
	private String complemento;
	private String municipio;
	private String cidade;
	private Uf uf;
    private Cliente cliente;
    
	public ClienteEnderecoDTO(Endereco endereco) {
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.municipio = endereco.getMunicipio();
		this.cidade = endereco.getCidade();
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public Uf getUf() {
		return uf;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
