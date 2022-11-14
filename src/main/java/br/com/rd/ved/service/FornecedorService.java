package br.com.rd.ved.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Fornecedor;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.FornecedorRepository;
import br.com.rd.ved.repository.ProdutoRepository;
import br.com.rd.ved.repository.UfRepository;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;
	private final EnderecoRepository enderecoRepository;
	private final ProdutoRepository produtoRepository;
	private final UfRepository ufRepository;
	private Boolean sistema = true;

	public FornecedorService(FornecedorRepository fornecedorRepository, EnderecoRepository enderecoRepository,
			ProdutoRepository produtoRepository, UfRepository ufRepository) {
		super();
		this.fornecedorRepository = fornecedorRepository;
		this.enderecoRepository = enderecoRepository;
		this.produtoRepository = produtoRepository;
		this.ufRepository = ufRepository;
	}

	public void iniciar(Scanner sc) throws ParseException {
		int acao;
		while (sistema) {
			System.out.println("Qual a ação que será realizada em Fornecedor");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			System.out.println("5 - Adicionar Produto");

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
			case 5:
				 salvarProduto(sc);
				break; 
			default:
				sistema = false;
				
				break;
			}
		}
	}

	private void deletar(Scanner sc) {
		System.out.println("Informe o ID do Fornecedor a ser Deletado:");
		Integer id = Integer.parseInt(sc.nextLine());
		fornecedorRepository.deleteById(id);
		System.out.println("Fornecedor deletado com sucesso!");

	}

	private void visualizar() {
		Iterable<Fornecedor> fornecedores = fornecedorRepository.findAll();
		fornecedores.forEach(fornecedor -> System.out.println(fornecedor));
	}

	private void atualizar(Scanner sc) {

		System.out.println("Informe o Id do fornecedor a ser atualizado");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Informe o nome para o Fornecedor");
		String razaoSocial = sc.nextLine();

		System.out.println("Informe o cnpj do Fornecedor");
		String cnpj = sc.nextLine();

		System.out.println("Informe o email do Fornecedor");
		String email = sc.nextLine();

		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		fornecedor.get().setCnpj(cnpj);
		fornecedor.get().setEmail(email);
		fornecedor.get().setRazaoSocial(razaoSocial);

		System.out.println("deseja alterar o endereco do fornecedor [s/n] ? ");
		String resposta = sc.nextLine();
		if (resposta.equals("s")) {
			System.out.println("informe o endereco que deseja Atualizar:");

			List<Endereco> enderecos = fornecedor.get().getEnderecos();
			enderecos.forEach(f -> System.out.println(f));

			System.out.println("informe o Id do Endereco que deseja alterar:");
			Integer enderecoId = Integer.parseInt(sc.nextLine());

			Optional<Endereco> end = enderecoRepository.findById(enderecoId);

			enderecos.add(atualizarEndereco(sc, end.get()));
			fornecedor.get().setEnderecos(enderecos);
		}
		fornecedorRepository.save(fornecedor.get());
		System.out.println("Fornecedor Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {

		System.out.println("Informe a razão social do fornecedor");
		String razaoSocial = sc.nextLine();

		System.out.println("Informe o cnpj do fornecedor");
		String cnpj = sc.nextLine();

		System.out.println("Informe o email do fornecedor");
		String email = sc.nextLine();

		Fornecedor fornecedor = new Fornecedor(razaoSocial, cnpj, email);

		System.out.println("deseja cadastrar o endereco do fornecedor [s/n] ? ");

		String resposta = sc.nextLine();
		if (resposta.equals("s")) {
			fornecedor.setEnderecos(salvarEndereco(sc));
		}

		fornecedorRepository.save(fornecedor);
		System.out.println("Fornecedor Salvo com Sucesso");

	}

	private void salvarProduto(Scanner sc) throws ParseException {
		System.out.printf("Informe o ID do Fornecedor.:");
		Integer id = Integer.parseInt(sc.nextLine()); 
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		System.out.printf("informe o ID do Produto que deseja adicionar:");
		Integer produtoId = Integer.parseInt(sc.nextLine());
		List<Produto> produtos = fornecedor.get().getProdutos();
		Optional<Produto> produto = produtoRepository.findById(produtoId);
		produtos.add(produto.get());
		System.out.println("Produto: " + produto.get().getNomeProduto() + ", Adicionado ao Fornecedor: " + fornecedor.get().getRazaoSocial() + ", com Sucesso!");
	}

	private Endereco atualizarEndereco(Scanner sc, Endereco endereco) {
		System.out.println("Digite o Cep do Endereço:");
		String cep = sc.nextLine();
		System.out.println("Digite a Rua do Endereço: ");
		String rua = sc.nextLine();
		System.out.println("Digite o Numero do Endereço: ");
		Integer numero = Integer.parseInt(sc.nextLine());
		System.out.println("Digite o Complemento do Endereço: ");
		String complemento = sc.nextLine();
		System.out.println("Digite o Municipio do Endereço: ");
		String municipio = sc.nextLine();
		System.out.println("Digite o Cidade do Endereço: ");
		String cidade = sc.nextLine();
		System.out.println("Digite o Id do UF do endereço: ");
		Integer ufId = Integer.parseInt(sc.nextLine());

		Optional<Uf> uf = ufRepository.findById(ufId);
		endereco.setCep(cep);
		endereco.setMunicipio(municipio);
		endereco.setComplemento(complemento);
		endereco.setCidade(cidade);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setUf(uf.get());
		enderecoRepository.save(endereco);

		System.out.println("endereco Alterado com Sucesso");
		return endereco;
	}

	private List<Endereco> salvarEndereco(Scanner sc) {
		List<Endereco> enderecos = new ArrayList<>();

		System.out.println("Digite o Cep do Endereço");
		String cep = sc.nextLine();
		System.out.println("Digite a Rua do Endereço");
		String rua = sc.nextLine();
		System.out.println("Digite o Numero do Endereço");
		Integer numero = Integer.parseInt(sc.nextLine());
		System.out.println("Digite o Complemento do Endereço");
		String comlemento = sc.nextLine();
		System.out.println("Digite o Municipio do Endereço");
		String municipio = sc.nextLine();
		System.out.println("Digite o Cidade do Endereço");
		String cidade = sc.nextLine();

		System.out.println("Digite o ID da Uf do endereco");
		Integer ufId = Integer.parseInt(sc.nextLine());

		Optional<Uf> uf = ufRepository.findById(ufId);

		Endereco endereco = new Endereco(cep, rua, numero, comlemento, municipio, cidade);
		endereco.setUf(uf.get());

		enderecoRepository.save(endereco);
		System.out.println("Endereco Salvo com Sucesso");
		enderecos.add(endereco);
		return enderecos;
	}

}
