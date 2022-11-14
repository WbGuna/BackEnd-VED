package br.com.rd.ved.controller;

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
import br.com.rd.ved.dto.ProdutoDTO;
import br.com.rd.ved.dto.ReceitaDTO;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<ProdutoCardDTO> listarCard() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoCardDTO.converter(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> detalhar(@PathVariable("id") Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(produto.get()));
		}
		return ResponseEntity.notFound().build();
	} 	 
	
	@GetMapping("/{id}/receita")
	public ResponseEntity<ReceitaDTO> Receita(@PathVariable("id") Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(new ReceitaDTO(produto.get().getReceita()));
		}
		return ResponseEntity.notFound().build();
	} 
	 
	
	@GetMapping("/{id}/")
	public List<ProdutoCardDTO> demais(@PathVariable("id") Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		List<Produto> produtos = produtoRepository.findProdutosPorCategoria(produto.get().getCategoria().getDescricao());
		return  ProdutoCardDTO.converter(produtos);
	} 
	
	//Escolher plano por id
	@GetMapping("/plano/{id}")
	public ResponseEntity<PlanoDTO> planos (@PathVariable("id") Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(new PlanoDTO(produto.get()));
		}
		return ResponseEntity.notFound().build();
	} 

}
