package br.com.rd.ved.service;
//
//import java.util.Optional;
//import java.util.Scanner;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//
//import br.com.rd.ved.model.Endereco;
//import br.com.rd.ved.model.Uf;
//import br.com.rd.ved.repository.EnderecoRepository;
//import br.com.rd.ved.repository.UfRepository;
//
//@Service
//public class EnderecoService {
//	private final EnderecoRepository enderecoRepository;
//	private final UfRepository ufRepository;
//	private Boolean sistema = true;
//	
//	
//	public EnderecoService(EnderecoRepository enderecoRepository, CrudRepository ufRepository) {
//		super();
//		this.enderecoRepository = enderecoRepository;
//		this.ufRepository = (UfRepository) ufRepository;
//	}
//
//	public void iniciar(Scanner sc) {
//		int acao;
//
//		while (sistema) {
//			System.out.println("Qual a ação que será realizada em Endereco");
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
//	private void salvar(Scanner sc) {
//		System.out.println("Digite o Cep do Endereço");
//		String cep = sc.nextLine();
//		System.out.println("Digite a Rua do Endereço");
//		String rua = sc.nextLine();
//		System.out.println("Digite o Numero do Endereço");
//		Integer numero = Integer.parseInt(sc.nextLine());
//		System.out.println("Digite o Complemento do Endereço");
//		String comlemento = sc.nextLine();
//		System.out.println("Digite o Municipio do Endereço");
//		String municipio = sc.nextLine();
//		System.out.println("Digite o Cidade do Endereço");
//		String cidade = sc.nextLine();
//		System.out.println("Digite o ID da Uf do endereco");
//		Integer ufId = Integer.parseInt(sc.nextLine());
//
//		Optional<Uf> uf = ufRepository.findById(ufId);
//
//		Endereco endereco = new Endereco(cep, rua, numero, comlemento, municipio, cidade);
//		endereco.setUf(uf.get());
//
//		enderecoRepository.save(endereco);
//
//		System.out.println("Endereco Salvo com Sucesso");
//
//	}
//
//	private void atualizar(Scanner sc) {
//		System.out.println("Digite o Cep do Endereço:");
//		Integer id = Integer.parseInt(sc.nextLine());
//		System.out.println("Digite o Cep do Endereço:");
//		String cep = sc.nextLine();
//		System.out.println("Digite a Rua do Endereço: ");
//		String rua = sc.nextLine();
//		System.out.println("Digite o Numero do Endereço: ");
//		Integer numero = Integer.parseInt(sc.nextLine());
//		System.out.println("Digite o Complemento do Endereço: ");
//		String complemento = sc.nextLine();
//		System.out.println("Digite o Municipio do Endereço: ");
//		String municipio = sc.nextLine();
//		System.out.println("Digite o Cidade do Endereço: ");
//		String cidade = sc.nextLine();
//		System.out.println("Digite o Id do UF do endereço: ");
//		Integer ufId = Integer.parseInt(sc.nextLine());
//
//		Optional<Uf> uf = ufRepository.findById(ufId);
//		Optional<Endereco> endereco = enderecoRepository.findById(id);
//		endereco.get().setCep(cep);
//		endereco.get().setMunicipio(municipio);
//		endereco.get().setComplemento(complemento);
//		endereco.get().setCidade(cidade);
//		endereco.get().setNumero(numero);
//		endereco.get().setRua(rua);
//		endereco.get().setUf(uf.get());
//	
//		enderecoRepository.save(endereco.get());
//
//		System.out.println("endereco Alterado com Sucesso");
//	}
//
//	private void visualizar() {
//		Iterable<Endereco> enderecos = enderecoRepository.findAll();
//		enderecos.forEach(e -> System.out.println(e));
//	}
//
//	private void deletar(Scanner sc) {
//		System.out.println("Digite o ID do endereco:");
//		Integer id = Integer.parseInt(sc.nextLine());
//		enderecoRepository.deleteById(id);
//		System.out.println("Endereco deletado com Sucesso");
//	}
//
//	
//}
