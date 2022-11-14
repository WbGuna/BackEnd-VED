package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receita")
	private Integer id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "ingredientes")
	private String ingredientes;
	@Column(name = "preparo")
	private String preparo;

	@OneToMany(mappedBy = "receita")
	private List<Produto> produtos; 
	
	public Receita() {
		super();
	}

	public Receita(Integer id, String nome, String ingredientes, String preparo) {
		this.id = id;
		this.titulo = nome;
		this.ingredientes = ingredientes;
		this.preparo = preparo;
	}

	public Receita(String nome, String ingredientes, String preparo) {
		this.titulo = nome;
		this.ingredientes = ingredientes;
		this.preparo = preparo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return titulo;
	}

	public void setNome(String nome) {
		this.titulo = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + titulo + ", ingredientes=" + ingredientes + ", preparo=" + preparo
				+ "]";
	}

}
