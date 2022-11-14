package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Produto;

public class ProdutoDTO {
	private Integer id;
	private String nome;
	private BigDecimal preco;
	private String url;
	private String descricao;
	private Double peso;
	private String categoria;
	private String statusProduto; 
	private Integer quantidade = 1;
	private String armazenamento; 
	private Integer estoque;

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNomeProduto();
		this.preco = produto.getPreco();
		this.url = produto.getUrl();
		this.descricao = produto.getDescricao();
		this.peso = produto.getPeso();
		this.estoque = produto.getQuantidade();
		this.categoria = produto.getCategoria().toString();
		this.statusProduto = produto.getStatusProduto().toString(); 
		this.armazenamento = produto.getArmazenamento().toString();
	}

	public ProdutoDTO() {

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getUrl() {
		return url;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	
	public Integer getEstoque() {
		return estoque;
	}

	public String getCategoria() {
		return categoria;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public String getStatusProduto() {
		return statusProduto;
	}

	public static List<ProdutoDTO> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
