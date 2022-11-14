package br.com.rd.ved.controller;

import java.net.URI;
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
import br.com.rd.ved.dto.ClienteDTO;
import br.com.rd.ved.formdto.AtualizarClienteForm;
import br.com.rd.ved.formdto.ClienteForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDTO> Listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDTO.converter(clientes);

	}

	@PostMapping("/novo")
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm clienteForm,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converter(clienteRepository);
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDTO(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete={id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity<ClienteDTO> atualizar(
			@RequestBody @Valid AtualizarClienteForm clienteForm) {
		
		Optional<Cliente> cliente = clienteRepository.findByEmail(clienteForm.getEmail()); 
		
		if (cliente.isPresent() && clienteForm.validarSenha(clienteForm.getSenha(), cliente.get().getSenha()) ) {
			
			Cliente atualizado = clienteForm.atualizar(cliente.get());
			 clienteRepository.save(atualizado);
			return ResponseEntity.ok(new ClienteDTO(atualizado));
		}
		return ResponseEntity.notFound().build();

	} 
}