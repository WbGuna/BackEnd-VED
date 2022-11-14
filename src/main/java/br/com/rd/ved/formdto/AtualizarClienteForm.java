package br.com.rd.ved.formdto;

import javax.validation.constraints.NotBlank;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rd.ved.model.Cliente;

public class AtualizarClienteForm {

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	private String nomeSocial;

	@NotBlank
	private String telefone;

	private String Email;

	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente atualizar(Cliente cliente) {
		cliente.setNome(nome);
		cliente.setSobreNome(sobrenome);
		cliente.setNomeSocial(nomeSocial);
		cliente.setTelefone(telefone);
		return cliente;

	}

	public boolean validarSenha(String senha, String senhaCrypto) {
		BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), senhaCrypto);
		return response.verified;
	}
}
