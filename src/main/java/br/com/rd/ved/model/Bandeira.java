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
@Table(name = "bandeira")
public class Bandeira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bandeira")
	private Integer id;
	@Column(name = "nome_bandeira", nullable = false)
	@Size(max = 30)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idBandeira")
	private List <Cartao> lista; 

	public Bandeira() {
		super();
	}

	public Bandeira(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Bandeira(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Bandeira [id=" + id + ", nome=" + nome + "]";
	}

}