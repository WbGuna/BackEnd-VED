package br.com.rd.ved.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private Boolean sistema = true;

	private Integer id;
	private Date dataNascimento;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void iniciar(Scanner sc) throws ParseException {
		int acao;
		while (sistema) {
			System.out.println("Qual a ação que será realizada em Cliente");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			acao = Integer.parseInt(sc.nextLine());

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}

	private void deletar(Scanner sc) {
		int id;
		System.out.println("Informe o ID do Cliente a ser Deletado");

		id = Integer.parseInt(sc.nextLine());

		clienteRepository.deleteById(id);

		System.out.println("Cliente deletado com sucesso");

	}

	private void visualizar() {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		clientes.forEach(cliente -> System.out.println(cliente));
	}
@Transactional	//não executa se todos não derem certo
	private void atualizar(Scanner sc) {

		System.out.println("Informe o Id do registro a ser atualizado");
		id = Integer.parseInt(sc.nextLine());
		Cliente cliente = clienteRepository.findById(id).get(); //select no banco pelo id
		
		System.out.println("Informe o nome para o Cliente");
		String nomeCliente = sc.next();
		

		System.out.println("Informe o sobre Nome para o Cliente");
		String sobreNomeCliente = sc.nextLine();

		System.out.println("Informe o nome Social para o Cliente");
		String nomeSocial = sc.nextLine();

		System.out.println("Informe a nova telefone para o Cliente");
		String telefone = sc.nextLine();

		System.out.println("Informe a nova senha para o Cliente");
		String senha = sc.nextLine();
		
		cliente.setNome(nomeCliente);
		cliente.setSobreNome(sobreNomeCliente);
		cliente.setNomeSocial(nomeSocial);
		cliente.setTelefone(telefone);
		cliente.setSenha(senha);
		
		
		clienteRepository.saveAndFlush(cliente);

		System.out.println("Cliente Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {
		
	
		System.out.println("Informe o nome para o Cliente");
		String nomeCliente = sc.next();
		sc.nextLine();

		System.out.println("Informe o sobre Nome para o Cliente");
		String sobreNomeCliente = sc.next();
		sc.nextLine();
		
		System.out.println("Informe o nome Social para o Cliente");
		String nomeSocial = sc.nextLine();
				
		System.out.println("Informe o cpf do Cliente");
		String cpf = sc.nextLine();
		
		System.out.println("Informe a data de nascimento do Cliente (--/--/----)");
		String dt = sc.nextLine();
		dataNascimento = formato.parse(dt);

		System.out.println("Informe seu email para o Cliente");
		String email = sc.nextLine();

		System.out.println("Informe o telefone do Cliente");
		String telefone = sc.nextLine();

		System.out.println("Informe uma senha para o Cliente");
		String senha = sc.nextLine();
		senha = codificarSenha(senha);

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nomeCliente);
		cliente.setSobreNome(sobreNomeCliente);
		cliente.setNomeSocial(nomeSocial);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setSenha(senha);

		clienteRepository.save(cliente);

		System.out.println("Cliente Salvo com Sucesso");

	}
	
	public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        
    }
	
//	public boolean validarSenha(String senha, String senhaCrypto) {
//        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), senhaCrypto);
//        return response.verified;
//    }
}