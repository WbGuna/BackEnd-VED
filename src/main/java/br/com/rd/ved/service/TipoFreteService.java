package br.com.rd.ved.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.TipoFrete;
import br.com.rd.ved.repository.TipoFreteRepository;

@Service
public class TipoFreteService {
	private final TipoFreteRepository tipoFreteRepository;
	private Boolean sistema = true;

	public TipoFreteService(TipoFreteRepository tipoFreteRepository) {
		this.tipoFreteRepository = tipoFreteRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no tipo frete");
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
			case 3:
				visualizar();
				
				break;
			case 4:
				atualizar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {
		System.out.println("Informe descrição para o tipo frete:");
		String descricao = sc.nextLine();
		
		TipoFrete tipoFrete = new TipoFrete(descricao);
		tipoFreteRepository.save(tipoFrete);
		System.out.println("Tipo Frete salvo com sucesso!");
	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID d Tipo Frete:");
		Integer id = Integer.parseInt(sc.nextLine());
		System.out.println("Informe a nova descrição:");
		String descricao = sc.nextLine();
		Optional<TipoFrete> tipoFrete = tipoFreteRepository.findById(id);
		tipoFrete.get().setDescricao(descricao);
		tipoFreteRepository.save(tipoFrete.get());
		System.out.println("Tipo Frete Alterado com Sucesso");
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do tipo frete");
		Integer id = Integer.parseInt(sc.nextLine());
		tipoFreteRepository.deleteById(id);
		System.out.println("tipo frete Deletado com Sucesso");
	} 
	
	private void visualizar() {
		Iterable<TipoFrete> tipoFrete = tipoFreteRepository.findAll();
		tipoFrete.forEach(tipo -> System.out.println(tipo));
	}

}
