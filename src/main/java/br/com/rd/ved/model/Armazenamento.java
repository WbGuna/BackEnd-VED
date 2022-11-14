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

@Entity
@Table(name="armazenamento")
public class Armazenamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_armazenamento")
	private Integer id; 
	@Column(name="descricao_armazenamento", nullable = false) 
	@Size(max = 50)
	private String descricao; 
	
	@OneToMany(mappedBy = "armazenamento")
	private List<Produto> produtos;
	
	public Armazenamento() {
		super();
	}

	public Armazenamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Armazenamento(String descricao) {
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
