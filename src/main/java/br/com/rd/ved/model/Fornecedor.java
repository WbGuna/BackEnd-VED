package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Integer id;
	@Column(name = "razao_social")
	@Size(max = 50)
	private String razaoSocial;
	@Column(name = "cnpj")
	@Size(max = 20)
	private String cnpj;
	@Column(name = "email")
	@Size(max = 30)
	private String email;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "fornecedor_endereco", joinColumns = {
			@JoinColumn(name = "id_fornecedor") }, inverseJoinColumns = { @JoinColumn(name = "id_endereco") })
	private List<Endereco> enderecos;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "fornecedor_produto", joinColumns = {
			@JoinColumn(name = "id_fornecedor") }, inverseJoinColumns = { @JoinColumn(name = "id_produto") })
	private List<Produto> produtos;

	@JsonIgnore
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Fornecedor() {
		super();
	}

	public Fornecedor(String razaoSocial, String cnpj, String email) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", email=" + email
				+ ", enderecos=" + enderecos + "]";
	}

}
