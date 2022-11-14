package br.com.rd.ved.formdto;

import java.util.List;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Endereco;

public class ClienteEnderecoForm {

	List<Endereco> enderecos; 
	Cliente clientes;
	
	public ClienteEnderecoForm(Cliente clientes) {
		this.clientes = clientes;
	}
	
	
	
	
}
