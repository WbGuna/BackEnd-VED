package br.com.rd.ved.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.UfRepository;

@Service
public class UfService {
	private final UfRepository ufRepository;
	private Boolean sistema = true;

	public UfService(UfRepository ufRepository) {
		super();
		this.ufRepository = ufRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no UF");
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
		System.out.println("Digite a descricao a UF:");
		String descricao = sc.nextLine();
		Uf uf = new Uf(descricao);
		ufRepository.save(uf);
		System.out.println("Uf Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID da Uf:");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.println("Informe a nova descrição:");
		String descricao = sc.nextLine();
		Optional<Uf> uf = ufRepository.findById(id);
		uf.get().setDescricao(descricao);
		ufRepository.save(uf.get());
		System.out.println("UF Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<Uf> ufs = ufRepository.findAll();
		ufs.forEach(uf -> System.out.println(uf));
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID da Uf");
		Integer id = Integer.parseInt(sc.nextLine());
		ufRepository.deleteById(id);
		System.out.println("UF Deletado com Sucesso");
	}

}
