package br.com.rd.ved.formdto;

import java.util.List;
import java.util.Optional;

import br.com.rd.ved.dto.EnderecoDTO;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.UfRepository;

public class EnderecoForm {

	private String cep;
	private String rua;
	private Integer numero;
	private String complemento;
	private String municipio;
	private String cidade;
	private Integer uf;
	
	public EnderecoForm(String cep, String rua, String numero, String complemento, String municipio, String cidade
			, String uf) {
		this.cep = cep;
		this.rua = rua;
		this.numero = Integer.parseInt(numero);
		this.complemento = complemento;
		this.municipio = municipio;
		this.cidade = cidade; 
		this.uf = Integer.parseInt(uf);
	}

	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Endereco converter(UfRepository ur) {
		Endereco endereco = new Endereco(cep, rua, numero, complemento, municipio, cidade);
		Optional<Uf> uf = ur.findById(this.uf);
		endereco.setUf(uf.get());
		return endereco;
	}

	public List<EnderecoDTO> cadastrarEndereco(Endereco endereco, Cliente cliente, ClienteRepository cr) {
		List<Endereco> enderecos;
		enderecos = cliente.getEnderecos();
		enderecos.add(endereco);
		cliente.setEnderecos(enderecos);
		cr.save(cliente);
		return EnderecoDTO.converter(enderecos);

	} 
	
	public List<EnderecoDTO> deletarEndereco(Endereco endereco, Cliente cliente, ClienteRepository cr) {
		List<Endereco> enderecos;
		enderecos = cliente.getEnderecos();
		enderecos.add(endereco);
		cliente.setEnderecos(enderecos);
		cr.save(cliente);
		return EnderecoDTO.converter(enderecos);

	} 
	
	public Endereco atualizar(Endereco endereco, UfRepository ur ) {
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setMunicipio(municipio);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		Optional<Uf> uf = ur.findById(this.uf); 
		endereco.setUf(uf.get());
		return endereco ; 
		
	}	
}