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
@Table(name="serie")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_serie")
	private Integer id;
	@Column(name="descricao_serie")
	@Size(max = 50)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy="serie")
	private List <NotaFiscal> series; 
	
	public Serie() {
		super();
	}

	public Serie(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Serie(String descricao) {
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
		return "Serie [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
