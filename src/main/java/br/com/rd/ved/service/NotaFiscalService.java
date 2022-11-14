package br.com.rd.ved.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.NotaFiscal;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Serie;
import br.com.rd.ved.repository.NotaFiscalRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.SerieRepository;

@Service
public class NotaFiscalService {
	private final NotaFiscalRepository notaFiscalRepository;
	private final PedidoRepository pedidoRepository;
	private final SerieRepository serieRepository;
	
	private Boolean sistema = true;

	public NotaFiscalService(NotaFiscalRepository notaFiscalRepository , PedidoRepository pedidoRepository , SerieRepository serieRepository) {
		this.notaFiscalRepository = notaFiscalRepository;
		this.pedidoRepository = pedidoRepository;
		this.serieRepository = serieRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Funcionario");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Deletar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Atualizar");

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

			default:
				sistema = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {

		System.out.println("Informe a chave de acesso");
		String chaveacesso = sc.nextLine();

		System.out.println("Informe id do Pedido");
		Integer pedidos = Integer.parseInt(sc.nextLine());

		System.out.println("Informe id da serie");
		Integer series = Integer.parseInt(sc.nextLine());

		NotaFiscal notaFiscal = new NotaFiscal();

		notaFiscal.setChaveAcesso(chaveacesso);

		Optional<Pedido> pedido = pedidoRepository.findById(pedidos);
		notaFiscal.setPedido(pedido.get());

		Optional<Serie> serie = serieRepository.findById(series);
		notaFiscal.setSerie(serie.get());


		notaFiscalRepository.save(notaFiscal);

		System.out.println("save produto com sucesso");

	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID Nota Fiscal");
		Integer id = Integer.parseInt(sc.nextLine());
		notaFiscalRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}

	private void visualizar() {
		Iterable<NotaFiscal> notaFiscal = notaFiscalRepository.findAll();
		notaFiscal.forEach(p -> System.out.println(notaFiscal));
	}
}
