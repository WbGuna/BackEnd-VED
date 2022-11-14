package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Usuario;
import br.com.rd.ved.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private Boolean sistema = true;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Funcionario");
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

	private void salvar(Scanner sc) {
		System.out.println("Digite O nome do Usuario:");
		String nome = sc.nextLine();
		System.out.println("Digite O email do Usuario:");
		String email = sc.nextLine();
		System.out.println("Digite a senha do Usuario:");
		String senha = sc.nextLine();
		Usuario usuario = new Usuario(nome, email, senha);
		usuarioRepository.save(usuario);
		System.out.println("Usuario Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID do Usuario:");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Digite O nome do Usuario:");
		String nome = sc.nextLine();
		System.out.println("Digite O email do Usuario:");
		String email = sc.nextLine();
		System.out.println("Digite a senha do Usuario:");
		String senha = sc.nextLine();
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuarioRepository.save(usuario);
		System.out.println("Usuario Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<Usuario> usuario = usuarioRepository.findAll();
		usuario.forEach(user -> System.out.println(user));
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do Usuario");
		Integer id = Integer.parseInt(sc.nextLine());
		usuarioRepository.deleteById(id);
		System.out.println("Usuario Deletado com Sucesso");
	}
}
