package br.com.rd.ved.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.TipoFrete;
import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.FreteRepository;
import br.com.rd.ved.repository.TipoFreteRepository;
import br.com.rd.ved.repository.UfRepository;

@Service
public class FreteService {
	private final FreteRepository freteRepository;
	private final TipoFreteRepository tipoFreteRepository;
	private final UfRepository ufRepository;
	private Boolean sistema = true;

	public FreteService(FreteRepository freteRepository, TipoFreteRepository tipoFreteRepository,
			UfRepository ufRepository) {
		this.freteRepository = freteRepository;
		this.tipoFreteRepository = tipoFreteRepository;
		this.ufRepository = ufRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no frete");
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
		System.out.println("Digite o ID da UF do Frete:");
		Integer ufId = Integer.parseInt(sc.nextLine());
		Optional<Uf> uf = ufRepository.findById(ufId);

		System.out.println("Digite o ID do Tipo do Frete:");
		Integer tipoId = Integer.parseInt(sc.nextLine());
		Optional<TipoFrete> tipoFrete = tipoFreteRepository.findById(tipoId);

		System.out.println("Digite o valor do Frete:");
		BigDecimal valor = new BigDecimal(sc.nextLine());

		Frete frete = new Frete(valor, uf.get(), tipoFrete.get());
		freteRepository.save(frete);
		System.out.println("Frete Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID do Frete a ser atualizado:");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Digite o ID da UF do Frete:");
		Integer ufId = Integer.parseInt(sc.nextLine());

		System.out.println("Digite o ID do Tipo_Frete do Frete:");

		Integer tipoId = Integer.parseInt(sc.nextLine());

		System.out.println("Digite o Valor do  Frete:");
		BigDecimal valor = new BigDecimal(sc.nextLine());

		Optional<Frete> frete = freteRepository.findById(id);
		Optional<TipoFrete> tipoFrete = tipoFreteRepository.findById(tipoId);
		Optional<Uf> uf = ufRepository.findById(ufId);
		frete.get().setTipoFrete(tipoFrete.get());
		frete.get().setUf(uf.get());
		frete.get().setValor(valor);
		freteRepository.save(frete.get());
		System.out.println("Frete Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<Frete> fretes = freteRepository.findAll();
		fretes.forEach(f -> System.out.println(f));
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID da Frete");
		Integer id = Integer.parseInt(sc.nextLine());
		freteRepository.deleteById(id);
		System.out.println("Frete Deletado com Sucesso");
	}

}
