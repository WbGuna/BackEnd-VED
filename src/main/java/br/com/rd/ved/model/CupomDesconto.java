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
@Table(name="cupom_desconto")
public class CupomDesconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cupom_desconto")
	private Integer id;
	@Column(name="descricao_desconto")
	@Size(max = 50)
	private String descricao;
	@Column(name="porcentagem_desconto")
	private Integer porcentagemDesconto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cupomDesconto")
	private List <Pedido> pedidos; 
	
	public CupomDesconto() {
		super();
	}

	public CupomDesconto(Integer id, String descricao, Integer porcentagemDesconto) {
		this.id = id;
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public CupomDesconto(String descricao, Integer porcentagemDesconto) {
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
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

	public Integer getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Integer porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "CupomDesconto [id=" + id + ", descricao=" + descricao + ", porcentagemDesconto=" + porcentagemDesconto
				+ "]";
	}
	
}
