//package br.com.rd.ved.service;
//
//import java.util.Scanner;
//
//import org.springframework.stereotype.Service;
//
//import br.com.rd.ved.model.Pix;
//import br.com.rd.ved.repository.PixRepository;
//
//@Service
//public class PixService {
//	private final PixRepository pixRepository;
//	private Boolean sistema = true;
//	
//	public PixService(PixRepository pixRepository) {
//		this.pixRepository = pixRepository;
//	}
//	
//	
//	public void iniciar(Scanner sc) {
//		int acao;
//
//		while (sistema) {
//			System.out.println("Qual a ação que será realizada no Funcionario");
//			System.out.println("0 - Sair");
//			System.out.println("1 - Salvar");
//			System.out.println("2 - deletar");
//			System.out.println("3 - Visualizar");
//			System.out.println("4 - atualizar");
//
//			acao = Integer.parseInt(sc.nextLine());
//
//			switch (acao) {
//			case 1:
//				salvar(sc);
//				break;
//			case 2:
//				deletar(sc);
//				break;
//				
//			default:
//				sistema = false;
//				break;
//			}
//		}
//	}
//	
//	
//	private void salvar(Scanner sc) {
//		 String codigo_pix;
//			System.out.println("Informe descrição para o pix");
//			codigo_pix = sc.next(); 
//			Pix pix = new Pix(codigo_pix);
//			pixRepository.save(pix);
//		
//	}
//	
//	private void deletar(Scanner sc) {
//		System.out.println("Digite o ID do pix");
//		sc.nextLine(); 
//		Integer id = Integer.parseInt(sc.nextLine());
//		pixRepository.deleteById(id);
//		System.out.println(" Deletado com Sucesso");
//	}
//	
//	
	
//}
