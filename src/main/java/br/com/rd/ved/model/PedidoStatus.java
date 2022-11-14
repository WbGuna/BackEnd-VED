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
@Table(name = "pedido_status")
public class PedidoStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_status")
	private Integer id;
	@Column(name = "descricao_status")
	@Size(max = 50)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pedidoStatus")
	private List <Pedido> listaPedido; 
	
	public PedidoStatus() {
		super();
	}

	public PedidoStatus(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public PedidoStatus(String descricao) {
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
		return "PedidoStatus [id=" + id + ", descricao=" + descricao + "]";
	}

}
