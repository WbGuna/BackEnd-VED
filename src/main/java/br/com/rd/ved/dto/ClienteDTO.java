package br.com.rd.ved.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.rd.ved.model.Cliente;

public class ClienteDTO {

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String nomeSocial;

	@NotBlank
	private String cpf;

	private Date dataNascimento;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	@NotBlank
	private String email;

	@NotBlank
	private String telefone;

	public ClienteDTO() {

	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() { 
		String hoje = formato.format(dataNascimento); 
		return hoje ;
	}
	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public ClienteDTO(Cliente obj) {
		nome = obj.getNome();
		sobrenome = obj.getSobreNome();
		nomeSocial = obj.getNomeSocial();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		email = obj.getEmail();
		telefone = obj.getTelefone();
	}

	public static List<ClienteDTO> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
