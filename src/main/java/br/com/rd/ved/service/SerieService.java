package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Serie;
import br.com.rd.ved.repository.SerieRepository;

@Service
public class SerieService {
	private final SerieRepository serieRepository;
	private Boolean sistema = true;
	
	public SerieService(SerieRepository serieRepository) {
		this.serieRepository = serieRepository;
	}
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Serie");
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
			System.out.println("Informe descrição para o Serie");
			descricao = sc.next(); 
			Serie serie = new Serie(descricao);
			serieRepository.save(serie);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do Serie");
		sc.nextLine(); 
		Integer id = Integer.parseInt(sc.nextLine());
		serieRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
	
	
	
}