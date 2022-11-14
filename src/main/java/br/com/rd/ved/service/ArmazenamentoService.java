package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Armazenamento;
import br.com.rd.ved.repository.ArmazenamentoRepository;

@Service
public class ArmazenamentoService {

	private final ArmazenamentoRepository armazenamentoRepository;
	private Boolean sistema = true;
	
	public ArmazenamentoService(ArmazenamentoRepository armazenamentoRepository) {
		this.armazenamentoRepository = armazenamentoRepository;
	}
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Armazenamento");
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
		 String descricao;
			System.out.println("Informe descrição para o armazenamento");
			descricao = sc.nextLine(); 
			Armazenamento armazenamento = new Armazenamento(descricao);
			armazenamentoRepository.save(armazenamento);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do armazenamento");
		sc.nextLine(); 
		Integer id = Integer.parseInt(sc.nextLine());
		armazenamentoRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
	
	
}
