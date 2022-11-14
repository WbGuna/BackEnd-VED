package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.repository.BandeiraRepository;

@Service
public class BandeiraService {
	private final BandeiraRepository bandeiraRepository;
	private Boolean sistema = true;

	public BandeiraService(BandeiraRepository bandeiraRepository) {
		this.bandeiraRepository = bandeiraRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Bandeira");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - deletar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - atualizar");

			acao = Integer.parseInt(sc.nextLine());

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				deletar(sc);
				break;

			default:
				sistema = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {
		System.out.println("Informe descrição para o Nome da bandeira");
		String nome = sc.nextLine();
		Bandeira bandeira = new Bandeira(nome);
		bandeiraRepository.save(bandeira);

	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do bandeira");
		Integer id = Integer.parseInt(sc.nextLine());
		bandeiraRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}

}
