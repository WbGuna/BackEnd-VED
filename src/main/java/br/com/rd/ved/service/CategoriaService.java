package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Categoria;
import br.com.rd.ved.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	private Boolean sistema = true;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
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
		 String descricao;
			System.out.println("Informe descrição para a categoria");
			descricao = sc.nextLine(); 
			Categoria categoria = new Categoria(descricao);
			categoriaRepository.save(categoria);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID da categoria");
		Integer id = Integer.parseInt(sc.nextLine());
		categoriaRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
	
	
}
