package br.com.rd.ved.service;

//import java.util.Scanner;
//
//import org.springframework.stereotype.Service;
//
//import br.com.rd.ved.model.Boleto;
//import br.com.rd.ved.repository.BoletoRepository;
//
//@Service
//public class BoletoService {
//	private final BoletoRepository boletoRepository;
//	private Boolean sistema = true;
//	
//	public BoletoService(BoletoRepository boletoRepository) {
//		this.boletoRepository = boletoRepository;
//	}
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
//		 String codigoBarras;
//			System.out.println("Informe descrição para o pix");
//			codigoBarras = sc.nextLine(); 
//			Boleto boleto = new Boleto(codigoBarras);
//			boletoRepository.save(boleto);
//		
//	}
//	
//	private void deletar(Scanner sc) {
//		System.out.println("Digite o ID do pix");
//		Integer id = Integer.parseInt(sc.nextLine());
//		boletoRepository.deleteById(id);
//		System.out.println(" Deletado com Sucesso");
//	}
//	
//	
//}
