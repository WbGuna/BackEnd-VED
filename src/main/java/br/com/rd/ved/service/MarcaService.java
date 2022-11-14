package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Marca;
import br.com.rd.ved.repository.MarcaRepository;

@Service
public class MarcaService {
	private final MarcaRepository marcaRepository;
	private Boolean sistema = true;
	
	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no marca5");
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
		 String nome_bandeira;
			System.out.println("Informe descrição para a marca");
			nome_bandeira = sc.nextLine(); 
			Marca marca = new Marca(nome_bandeira);
			marcaRepository.save(marca);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID da marca");
		Integer id = Integer.parseInt(sc.nextLine());
		marcaRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
}
