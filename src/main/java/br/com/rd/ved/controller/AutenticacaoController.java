package br.com.rd.ved.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.TokenDTO;
import br.com.rd.ved.formdto.LoginForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			Cliente cliente = new Cliente();
			cliente =  clienteRepository.getClienteByEmail(form.getEmail());
			return ResponseEntity.ok(new TokenDTO(token, "Bearer", cliente));
		} catch(AuthenticationException e){
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
}
