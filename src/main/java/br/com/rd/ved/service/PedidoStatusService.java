package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.PedidoStatusRepository;

@Service
public class PedidoStatusService {
	private final PedidoStatusRepository pedidoStatusRepository;
	private Boolean sistema = true;
	
	public PedidoStatusService(PedidoStatusRepository pedidoStatusRepository) {
		this.pedidoStatusRepository = pedidoStatusRepository;
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
		System.out.println("Digite a descrição do Pedido-Status:");
		String descricao = sc.nextLine();
		PedidoStatus pedidoStatus = new PedidoStatus(descricao);
		pedidoStatusRepository.save(pedidoStatus);
		System.out.println("Pedido Status Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID do Pedido-Status:");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Digite a descrição do Pedido-Status:");
		String descricao = sc.nextLine();
		PedidoStatus pedidoStatus = new PedidoStatus();
		pedidoStatus.setId(id);
		pedidoStatus.setDescricao(descricao);
		System.out.println("Pedido-Status Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<PedidoStatus> pedidoStatus = pedidoStatusRepository.findAll();
		pedidoStatus.forEach(pst -> System.out.println(pst));
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do Pedido-Status");
		Integer id = Integer.parseInt(sc.nextLine());
		pedidoStatusRepository.deleteById(id);
		System.out.println("Pedido-Status Deletado com Sucesso");
	}
	
}
