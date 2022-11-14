package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_marca")
	private Integer id;
	@Column(name="descricao_marca")
	@Size(max = 50)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marca")
	private List <Produto> produtos;
	
	

	@JsonIgnore
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Marca() {
		super();
	}

	public Marca(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Marca(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
