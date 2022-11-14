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
@Table(name = "status_produto")
public class StatusProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status_produto")
	private Integer id;
	@Column(name = "descricao_status")
	@Size(max = 30)
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "statusProduto")
	private List <Produto> produtos;



	public StatusProduto() {
		super();
	}

	public StatusProduto(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public StatusProduto(String descricao) {
		super();
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
		return descricao;
	}

}
