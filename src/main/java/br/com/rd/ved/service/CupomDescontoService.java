package br.com.rd.ved.service;

import java.text.ParseException;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.repository.CupomDescontoRepository;

@Service
public class CupomDescontoService {
	
	private final CupomDescontoRepository cupomDescontoRepository;
	private Boolean sistema = true;

	public CupomDescontoService(CupomDescontoRepository cupomDescontoRepository) {
		this.cupomDescontoRepository = cupomDescontoRepository;
	}

	public void iniciar(Scanner sc) throws ParseException {
		int acao;
		while (sistema) {
			System.out.println("Qual a ação que será realizada em Cupom de Desconto");
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

	private void deletar(Scanner sc) {
		int id;
		System.out.println("Informe o ID da cupomDesconto a ser Deletado");
		id = Integer.parseInt(sc.nextLine());

		cupomDescontoRepository.deleteById(id);
		System.out.println("cupomDesconto deletado com sucesso");

	}

	private void visualizar() {
		Iterable<CupomDesconto> cupomDescontos = cupomDescontoRepository.findAll();
		cupomDescontos.forEach(cupomDesconto -> System.out.println(cupomDesconto));
	}

	private void atualizar(Scanner sc) {

		System.out.println("Informe a descrição do cupomDesconto");
		String descricao = sc.nextLine();

		System.out.println("Informe a Porcentagem Desconto");
		Integer porcentagemDesconto = Integer.parseInt(sc.nextLine());
		
		CupomDesconto cupomDesconto = new CupomDesconto();
		cupomDesconto.setDescricao(descricao);
		cupomDesconto.setPorcentagemDesconto(porcentagemDesconto);

		cupomDescontoRepository.save(cupomDesconto);

		System.out.println("Cupom de Desconto Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {

		System.out.println("Informe o nome da cupomDesconto");
		String descricao = sc.nextLine();

		System.out.println("Informe a porcentagem do desconto");
		Integer porcentagemDesconto = Integer.parseInt(sc.nextLine());

		CupomDesconto cupomDesconto = new CupomDesconto(descricao, porcentagemDesconto);		
		cupomDescontoRepository.save(cupomDesconto);

		System.out.println("Cupom de Desconto Salvo com Sucesso");

	}

}