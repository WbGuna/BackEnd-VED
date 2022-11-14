package br.com.rd.ved.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="nota_fiscal")
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nota_fiscal")
	private Integer id;
	@Column(name="chave_acesso")
	private String chaveAcesso;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_serie", nullable=false)
	private Serie serie;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pedido", nullable=false)
	private Pedido pedido;

	public NotaFiscal() {
		super();
	}

	public NotaFiscal(Integer id, String chaveAcesso, Serie serie, Pedido pedido) {
		this.id = id;
		this.chaveAcesso = chaveAcesso;
		this.serie = serie;
		this.pedido = pedido;
	}

	public NotaFiscal(String chaveAcesso, Serie serie, Pedido pedido) {
		this.chaveAcesso = chaveAcesso;
		this.serie = serie;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", chaveAcesso=" + chaveAcesso + ", serie=" + serie + ", pedido=" + pedido
				+ "]";
	}
	
	
}
