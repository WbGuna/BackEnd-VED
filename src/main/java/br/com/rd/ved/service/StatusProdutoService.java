package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.StatusProduto;
import br.com.rd.ved.repository.StatusProdutoRepository;

@Service
public class StatusProdutoService {
	private final StatusProdutoRepository statusProdutoRepository;
	private Boolean sistema = true;
	
	public StatusProdutoService(StatusProdutoRepository statusProdutoRepository) {
		this.statusProdutoRepository = statusProdutoRepository;
	}
	

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Funcionario");
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
		 String descricao_status;
			System.out.println("Informe descrição para o status do produto");
			descricao_status = sc.nextLine(); 
			StatusProduto statusProduto = new StatusProduto(descricao_status);
			statusProdutoRepository.save(statusProduto);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do bandeira");
		Integer id = Integer.parseInt(sc.nextLine());
		statusProdutoRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
	
	
}