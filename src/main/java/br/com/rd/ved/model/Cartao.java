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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartao")
public class Cartao {

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
		Cartao other = (Cartao) obj;
		return Objects.equals(id, other.id);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cartao")
	private Integer id;
	@Column(name = "numeracao_cartao", nullable = false)
	private String numeroCartao;
	@Column(name = "nome_titular", nullable = false)
	private String nomeTitular;
	@Column(name = "cpf_titular", nullable = false)
	private String cpfTitular;
	@Column(name = "dia_vencimento", nullable = false)
	private Integer diaVencimento;
	@Column(name = "ano_vencimento", nullable = false)
	private Integer anoVencimento;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_bandeira", nullable=false)
	private Bandeira idBandeira;
	
	@JsonIgnore
	@ManyToMany(mappedBy="cartoes",fetch = FetchType.LAZY)
	private List<Cliente> cliente; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "cartao")
	private List <HistoricoPagamento> HistoricoPagamento; 
	
	public Cartao() {
		super();
	}

	public Cartao(String numeroCartao, String nomeTitular, String cpfTitular, Integer diaVencimento,
			Integer anoVencimento, Bandeira idBandeira) {

		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.diaVencimento = diaVencimento;
		this.anoVencimento = anoVencimento;
		this.idBandeira = idBandeira;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Integer getAnoVencimento() {
		return anoVencimento;
	}

	public void setAnoVencimento(Integer anoVencimento) {
		this.anoVencimento = anoVencimento;
	}

	public Bandeira getBandeiraId() {
		return idBandeira;
	}

	public void setBandeiraId(Bandeira bandeiraId) {
		this.idBandeira = bandeiraId;
	}

	
	public Bandeira getIdBandeira() {
		return idBandeira;
	}

	public void setIdBandeira(Bandeira idBandeira) {
		this.idBandeira = idBandeira;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<HistoricoPagamento> getHistoricoPagamento() {
		return HistoricoPagamento;
	}

	public void setHistoricoPagamento(List<HistoricoPagamento> historicoPagamento) {
		HistoricoPagamento = historicoPagamento;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", numeroCartao=" + numeroCartao + ", nomeTitular=" + nomeTitular + ", cpfTitular="
				+ cpfTitular + ", diaVencimento=" + diaVencimento + ", anoVencimento=" + anoVencimento + ", bandeiraId="
				+ idBandeira + "]";
	}

}
