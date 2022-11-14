//package br.com.rd.ved.service;
//import java.text.ParseException;
//import java.util.Scanner;
//import org.springframework.stereotype.Service;
//import br.com.rd.ved.model.Receita;
//import br.com.rd.ved.repository.ReceitaRepository;
//
//@Service
//public class ReceitaService {
//	
//	private final ReceitaRepository receitaRepository;
//	private Boolean sistema = true;
//
//	public ReceitaService(ReceitaRepository receitaRepository) {
//		this.receitaRepository = receitaRepository;
//	}
//
//	public void iniciar(Scanner sc) throws ParseException {
//		int acao;
//		while (sistema) {
//			System.out.println("Qual a ação que será realizada em Cliente");
//			System.out.println("0 - Sair");
//			System.out.println("1 - Salvar");
//			System.out.println("2 - Atualizar");
//			System.out.println("3 - Visualizar");
//			System.out.println("4 - Deletar");
//
//			acao = Integer.parseInt(sc.nextLine());
//
//			switch (acao) {
//			case 1:
//				salvar(sc);
//				break;
//			case 2:
//				atualizar(sc);
//				break;
//			case 3:
//				visualizar();
//				break;
//			case 4:
//				deletar(sc);
//				break;
//			default:
//				sistema = false;
//				break;
//			}
//		}
//	}
//
//	private void deletar(Scanner sc) {
//		int id;
//		System.out.println("Informe o ID da Receita a ser Deletado");
//
//		id = sc.nextInt();
//
//		receitaRepository.deleteById(id);
//
//		System.out.println("Receita deletado com sucesso");
//
//	}
//
//	private void visualizar() {
//		Iterable<Receita> receitas = receitaRepository.findAll();
//		receitas.forEach(receita -> System.out.println(receita));
//	}
//
//	private void atualizar(Scanner sc) {
//
//		System.out.println("Informe o título da Receita");
//		String nome = sc.nextLine();
//
//		System.out.println("Informe os ingredientes");
//		String ingredientes = sc.nextLine();
//
//		System.out.println("Informe o preparo");
//		String preparo = sc.nextLine();
//
//		Receita receita = new Receita();
//
//		receita.setIngredientes(ingredientes);
//		receita.setPreparo(preparo);
//
//		receitaRepository.save(receita);
//
//		System.out.println("Cliente Atualizado com Sucesso");
//
//	}
//
//	private void salvar(Scanner sc) throws ParseException {
//
//		System.out.println("Informe o nome da Receita");
//		sc.nextLine();
//		String nome = sc.nextLine();
//
//		System.out.println("Informe os ingredientes");
//		String ingredientes = sc.nextLine();
//
//		System.out.println("Informe o preparo");
//		String preparo = sc.nextLine();
//
//		Receita receita = new Receita();
//		receita.setIngredientes(ingredientes);
//		receita.setPreparo(preparo);
//
//		receitaRepository.save(receita);
//
//		System.out.println("Receita Salva com Sucesso");
//
//	}
//
//}
