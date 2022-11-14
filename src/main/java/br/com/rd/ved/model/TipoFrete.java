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
@Table(name="tipo_frete")
public class TipoFrete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_frete")
	private Integer id;
	@Column(name="descricao_frete")
	@Size(max = 50)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoFrete")
	private List<Frete> fretes;
	
	public TipoFrete() {
		super();
	}

	public TipoFrete(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoFrete(String descricao) {
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
	
	public List<Frete> getFretes() {
		return fretes;
	}

	public void setFretes(List<Frete> fretes) {
		this.fretes = fretes;
	}

	@Override
	public String toString() {
		return "TipoFrete [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
}
