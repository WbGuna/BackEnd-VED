package br.com.rd.ved.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.PlanoDTO;
import br.com.rd.ved.dto.ProdutoCardDTO;
import br.com.rd.ved.model.Categoria;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.CategoriaRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/valor/{valor}")
	public List<ProdutoCardDTO> filtroPorValor(@PathVariable("valor") Integer real) {
		List<Produto> prod = produtoRepository.findProdutosPorValor(real);

		return ProdutoCardDTO.converter(prod);
	}

	@GetMapping("/palavra/{palavra}")
	public List<ProdutoCardDTO> filtroPorPalavra(@PathVariable("palavra") String letra) {
		List<Produto> produto = produtoRepository.findProdutosPorPalavra(letra);
		
		return ProdutoCardDTO.converter(produto);
	}

	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> categoria = categoriaRepository.findAll();
		return categoria;
		}
	
	
		
	@GetMapping("/categoria={id}/produtos")
	public ResponseEntity<List<ProdutoCardDTO>> visualizar(@PathVariable("id") Integer id){

		Optional<Categoria> categoria = categoriaRepository.findById(id);
		

		if (categoria.isPresent()) {
			List<Produto> produtos = new ArrayList<>();
			produtos = categoria.get().getProdutos();
			return ResponseEntity.ok().body(ProdutoCardDTO.converter(produtos));
		}
		return ResponseEntity.notFound().build();
	}

//Listar planos(mensal,semestral e anual) por categoria Plano:
	@GetMapping("/categoria={id}/planos")
	public ResponseEntity<List<PlanoDTO>> visualizarPlanos(@PathVariable("id") Integer id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {
			List<Produto> produtos = new ArrayList<>();
			produtos = categoria.get().getProdutos();
			return ResponseEntity.ok().body(PlanoDTO.converter(produtos));
		}
		return ResponseEntity.notFound().build();
	}
}
