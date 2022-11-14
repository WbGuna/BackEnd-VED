package br.com.rd.ved.dto;

import br.com.rd.ved.model.Cliente;

public class TokenDTO {

	private String token;
	private String tipo;
	private String nome;
	private Integer id;

	public TokenDTO(String token, String tipo, Cliente cliente) {
		this.token = token;
		this.tipo = tipo;
		this.nome = cliente.getNome();
		this.id = cliente.getId();
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}
}
