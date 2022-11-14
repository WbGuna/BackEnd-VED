package br.com.rd.ved.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Categoria;
import br.com.rd.ved.model.Marca;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.model.StatusProduto;
import br.com.rd.ved.repository.CategoriaRepository;
import br.com.rd.ved.repository.MarcaRepository;
import br.com.rd.ved.repository.ProdutoRepository;
import br.com.rd.ved.repository.StatusProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	private final CategoriaRepository categoriaRepository;
	private final MarcaRepository marcaRepository;
	private final StatusProdutoRepository statusProdutoRepository;
	
	private Boolean sistema = true;
	
	public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository , MarcaRepository marcaRepository , StatusProdutoRepository statusProdutoRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
		this.marcaRepository = marcaRepository;
		this.statusProdutoRepository = statusProdutoRepository;
		
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
		
		 	System.out.println("Informe nome para o produto");
		 	String nomeProduto = sc.nextLine(); 
			
			System.out.println("Informe o preço para o produto");
			BigDecimal preco = new BigDecimal(sc.nextLine()); 
			
			System.out.println("Informe a url ");
			String url = sc.nextLine(); 
			
			System.out.println("Informe a descrição");
			String descricao = sc.nextLine(); 
			
			System.out.println("Informe o peso do produto");
			Double peso = Double.parseDouble(sc.nextLine());
			
			System.out.println("Informe id da categoria");
			Integer Categorias = Integer.parseInt(sc.nextLine());
			
			System.out.println("Informe id da marca");
			Integer Marcas = Integer.parseInt(sc.nextLine());
			
			System.out.println("Informe id da status do produto");
			Integer StatusProdutos = Integer.parseInt(sc.nextLine());
		
			Produto produto = new Produto();
		
			produto.setNomeProduto(nomeProduto);
			produto.setPreco(preco);
			produto.setUrl(url);
			produto.setDescricao(descricao);
			produto.setPeso(peso);
			
			Optional<Categoria> categoria = categoriaRepository.findById(Categorias);
			produto.setIdcategoria(categoria.get());
			
			Optional<Marca> marca = marcaRepository.findById(Marcas);
			produto.setIdmarca(marca.get());
			
			Optional<StatusProduto> statusproduto = statusProdutoRepository.findById(StatusProdutos);
			produto.setIdstatusProduto(statusproduto.get());
			
			produtoRepository.save(produto);
			
			System.out.println("save produto com sucesso");
	
	}
	
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do produto");
		Integer id = Integer.parseInt(sc.nextLine());
		produtoRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}

	
	private void visualizar() {
		Iterable<Produto> produto = produtoRepository.findAll();
		produto.forEach(p-> System.out.println(produto));
		} 

	
	
}
