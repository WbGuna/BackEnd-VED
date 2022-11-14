package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Endereco;

public class EnderecoDTO {
	private Integer id;
	private String cep;
	private String rua;
	private Integer numero;
	private String complemento;
	private String municipio;
	private String cidade;
	private String uf; 
	private Integer idUf;
	
	public EnderecoDTO(Endereco endereco) {
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.municipio = endereco.getMunicipio();
		this.cidade = endereco.getCidade(); 
		this.uf = endereco.getUf().getDescricao(); 
		this.id = endereco.getId(); 
		this.idUf = endereco.getUf().getId(); 
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getUf() {
		return uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public Integer getId() {
		return id;
	}

	public String getMunicipio() {
		return municipio;
	}
	

	public Integer getIdUf() {
		return idUf;
	}

	public String getCidade() {
		return cidade;
	}

	public static List<EnderecoDTO> converter(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}

}
