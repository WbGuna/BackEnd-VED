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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.EnderecoDTO;
import br.com.rd.ved.formdto.EnderecoForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.UfRepository;

@RestController
@RequestMapping("/cliente/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository er;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private UfRepository ur;

	@GetMapping("/{id}/detalhes")
	public List<EnderecoDTO> listar(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<Endereco> enderecos = cliente.get().getEnderecos(); 
		return EnderecoDTO.converter(enderecos);
	}

	@PostMapping("/{id}/novo")
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrar(@PathVariable("id") Integer id,
			@RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder uriBuilder) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Endereco endereco = enderecoForm.converter(ur);
		er.save(endereco);
		
		enderecoForm.cadastrarEndereco(endereco, cliente.get(), clienteRepository);
		URI uri = uriBuilder.path("/novo/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));

	}

	@GetMapping("/{id}/detalhar/{endereco}")
	public ResponseEntity<EnderecoDTO> detalhar(@PathVariable("id") Integer id,
			@PathVariable("endereco") Integer idEndereco) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Endereco> endereco = er.findById(idEndereco);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = cliente.get().getEnderecos();

		if (cliente.isPresent() && enderecos.contains(endereco.get())) {

			return ResponseEntity.ok().body(new EnderecoDTO(endereco.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}/delete/{endereco}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Integer id, @PathVariable("endereco") Integer idEndereco) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Endereco> endereco = er.findById(idEndereco);

		if (endereco.isPresent() && cliente.isPresent()) {
			List<Endereco> enderecos = new ArrayList<>();
			enderecos = cliente.get().getEnderecos();
			enderecos.remove(endereco.get());
			cliente.get().setEnderecos(enderecos); 
			clienteRepository.save(cliente.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/atualizar/{endereco}")
	@Transactional	
	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable("id") Integer id, @PathVariable("endereco") Integer idEndereco,
			@RequestBody @Valid EnderecoForm enderecoForm) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Endereco> endereco = er.findById(idEndereco);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = cliente.get().getEnderecos();
		
		if (cliente.isPresent() && enderecos.contains(endereco.get())) {
			Endereco atualizado = enderecoForm.atualizar(endereco.get(),ur); 
			er.save(atualizado);
			return ResponseEntity.ok(new EnderecoDTO(atualizado));
		}
		return ResponseEntity.notFound().build();

	}
}
