package br.com.rd.ved.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.CartaoDTO;
import br.com.rd.ved.formdto.ClienteCartaoForm;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.BandeiraRepository;
import br.com.rd.ved.repository.CartaoRepository;
import br.com.rd.ved.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BandeiraRepository bandeiraRepository;

	@GetMapping("/{id}/detalhes")
	public List<CartaoDTO> listar(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<Cartao> cartoes = cliente.get().getCartoes();
		return CartaoDTO.converter(cartoes);
	}

	@DeleteMapping("/{id}/deletar/{cartao}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Integer id, @PathVariable("cartao") Integer idcartao) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Cartao> cartao = cartaoRepository.findById(idcartao);

		if (cartao.isPresent() && cliente.isPresent()) {
			List<Cartao> cartoes = new ArrayList<>();
			cartoes = cliente.get().getCartoes();

			cartoes.remove(cartao.get());
			cliente.get().setCartoes(cartoes);

			clienteRepository.save(cliente.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/{id}/novo")
	@Transactional
	public ResponseEntity<CartaoDTO> cadastrar(@PathVariable("id") Integer id,
			@RequestBody @Valid ClienteCartaoForm clienteCartaoForm, UriComponentsBuilder uriBuilder) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		Cartao cartao = clienteCartaoForm.converter(bandeiraRepository);
		cartaoRepository.save(cartao);
		clienteCartaoForm.cadastrarCartao(cartao, cliente.get(), clienteRepository);

		URI uri = uriBuilder.path("/novo/{id}").buildAndExpand(cartao.getId()).toUri();
		return ResponseEntity.created(uri).body(new CartaoDTO(cartao));

	}

	@GetMapping("/{id}/detalhar/{cartao}")
	public ResponseEntity<CartaoDTO> detalhar(@PathVariable("id") Integer id,
			@PathVariable("cartao") Integer idCartao) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		List<Cartao> cartoes = new ArrayList<>();
		cartoes = cliente.get().getCartoes();

		if (cliente.isPresent() && cartoes.contains(cartao.get())) {

			return ResponseEntity.ok().body(new CartaoDTO(cartao.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
