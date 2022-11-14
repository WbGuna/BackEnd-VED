package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Produto;

public class PlanoDTO {

	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
		
	public PlanoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNomeProduto();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	public static List<PlanoDTO> converter(List<Produto> produto) {
		return produto.stream().map(PlanoDTO::new).collect(Collectors.toList());
	}
	
}
