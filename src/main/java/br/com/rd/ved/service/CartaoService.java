package br.com.rd.ved.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.repository.BandeiraRepository;
import br.com.rd.ved.repository.CartaoRepository;

@Service
public class CartaoService {

	private final CartaoRepository cartaoRepository;
	private final BandeiraRepository bandeiraRepository;
	
	
	private Boolean sistema = true;
	
	public CartaoService(CartaoRepository cartaoRepository , BandeiraRepository bandeiraRepository) {
		this.cartaoRepository = cartaoRepository;
		this.bandeiraRepository = bandeiraRepository;
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
		
		 String numeroCartao;
		 String nomeTitular;
		 String cpfTitular;
		 Integer diaVencimento;
		 Integer anoVencimento;
		 Integer Bandeira;
		 
		 
		 	System.out.println("Informe numero do Cartao");
		 	numeroCartao = sc.nextLine(); 
			
			
			System.out.println("Informe o Nome do titular Cartao");
			nomeTitular = sc.nextLine(); 
			
			System.out.println("Informe o cpf do titular Cartao");
			cpfTitular = sc.nextLine(); 
			
			System.out.println("Informe dia de vencimento do Cartao");
			diaVencimento = Integer.parseInt(sc.nextLine()); 
			
			System.out.println("Informe ano de vencimento do Cartao");
			anoVencimento = Integer.parseInt(sc.nextLine()) ;
			
			System.out.println("Informe id da bandeira");
			Bandeira = Integer.parseInt(sc.nextLine());
			
			Cartao cartao = new Cartao();
			
			cartao.setNumeroCartao(numeroCartao);
			cartao.setNomeTitular(nomeTitular);
			cartao.setCpfTitular(cpfTitular);
			cartao.setDiaVencimento(diaVencimento);
			cartao.setAnoVencimento(anoVencimento);
			Optional<Bandeira> bandeira = bandeiraRepository.findById(Bandeira);
			cartao.setBandeiraId(bandeira.get());
			
			cartaoRepository.save(cartao);
			
			System.out.println("save cartão com sucesso");
	
	}
	
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do cartao");
		sc.nextLine(); 
		Integer id = Integer.parseInt(sc.nextLine());
		cartaoRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}

	
	private void visualizar() {
		Iterable<Cartao> cartao = cartaoRepository.findAll();
		cartao.forEach(bandeira-> System.out.println(cartao));
		} 

	
}
