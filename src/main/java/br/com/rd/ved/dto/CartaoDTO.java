package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.model.Cartao;

public class CartaoDTO {
	
	private Integer id;
	private String numeroCartao;
	private String titular;
	private Integer anoVencimento;
	private Integer diaVencimento;
	private Bandeira idBandeira;

	public CartaoDTO(Cartao cartao) {
		this.id = cartao.getId();
		this.numeroCartao = cartao.getNumeroCartao();
		this.anoVencimento = cartao.getAnoVencimento();
		this.diaVencimento = cartao.getDiaVencimento();
		this.idBandeira = cartao.getBandeiraId(); 
		this.titular = cartao.getNomeTitular();

	}

	
	public String getNumeroCartao() {
		return numeroCartao;
	}


	public String getTitular() {
		return titular;
	}


	public Integer getAnoVencimento() {
		return anoVencimento;
	}


	public Integer getDiaVencimento() {
		return diaVencimento;
	}


	public Bandeira getIdBandeira() {
		return idBandeira;
	}


	public Integer getId() {
		return id;
	}


	public static List<CartaoDTO> converter(List<Cartao> cartoes) {

		return cartoes.stream().map(CartaoDTO::new).collect(Collectors.toList());

	}
}
