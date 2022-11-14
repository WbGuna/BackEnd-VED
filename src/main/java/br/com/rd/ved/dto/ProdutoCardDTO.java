package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.Produto;

public class ProdutoCardDTO {

	private Integer id;
	private String nomeProduto;
	private BigDecimal preco;
	private String url;
	private String descricao;
	private String statusProduto;
	private Integer quantidade = 1; 
	private Integer estoque;

	public ProdutoCardDTO(Produto produto) {
		this.id = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.preco = produto.getPreco();
		this.url = produto.getUrl();
		this.descricao = produto.getDescricao();
		this.statusProduto = produto.getStatusProduto().toString();  
		this.estoque = produto.getQuantidade();
		}
	
	public ProdutoCardDTO() {
	}

	public Integer getId() {
		return id;
	}

	public String getNomeProduto() {
		return nomeProduto;
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

	
	public Integer getEstoque() {
		return estoque;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getStatusProduto() {
		return statusProduto;
	} 
	
	public static List<ProdutoCardDTO> converter(List<Produto> produto){
		return produto.stream().map(ProdutoCardDTO::new).collect(Collectors.toList());
	}

	
}
