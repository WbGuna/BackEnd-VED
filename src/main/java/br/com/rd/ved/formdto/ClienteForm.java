package br.com.rd.ved.formdto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

public class ClienteForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String sobrenome;

	private String nomeSocial;

	@NotNull
	@NotEmpty
	private String cpf;

	@NotNull
	@NotEmpty
	private Date dataNascimento;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String telefone;

	@NotNull
	@NotEmpty
	private String senha;

	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	public ClienteForm(@NotEmpty String nome, @NotEmpty String sobrenome, String nomeSocial, @NotEmpty String cpf,
			@NotEmpty String dataNascimento, @NotEmpty String email, @NotEmpty String telefone, @NotEmpty String senha)
			throws ParseException {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = formato.parse(dataNascimento);
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

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

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        
    }

	public Cliente converter(ClienteRepository clienteRepository) {
		this.senha = codificarSenha(senha);
	return new Cliente(nome, sobrenome, nomeSocial, cpf, dataNascimento, email, telefone, senha);
		
		

	}
}

