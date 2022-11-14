package br.com.rd.ved.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;
	
	@Column(name = "cep")
	@Size(max = 10)
	private String cep;
	
	@Column(name = "rua")
	@Size(max = 100)
	private String rua;
	
	@Column(name = "numero")
	@Size(max = 10)
	private Integer numero;
	
	@Column(name = "complemento")
	@Size(max = 50)
	private String complemento;
	
	@Column(name = "municipio")
	@Size(max = 50)
	private String municipio;
	
	@Column(name = "cidade")
	@Size(max = 50)
	private String cidade;

	@JsonIgnore
	@OneToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_uf", nullable = false)
	private Uf uf;

	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
	private List<Fornecedor> fornecedores;

	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
	private List<Cliente> clientes;

	public Endereco() {
	}

	public Endereco(String cep, String rua, Integer numero, String complemento, String municipio, String cidade) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.municipio = municipio;
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", municipio=" + municipio + ", cidade=" + cidade + ", uf=" + uf + "]";
	}

}
