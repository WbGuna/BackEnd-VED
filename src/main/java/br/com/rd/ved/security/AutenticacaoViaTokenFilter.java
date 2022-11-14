package br.com.rd.ved.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	
	private TokenService tokenService;
	
	
	private ClienteRepository repository;
	
		
	public AutenticacaoViaTokenFilter(TokenService tokenService, ClienteRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);
	
	}

	
	private void autenticarCliente(String token) {
		Integer idCliente = tokenService.getIdCliente(token);
		Cliente cliente = repository.findById(idCliente).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}


	private String recuperarToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;			
		}		
		return token.substring(7, token.length());
	}

	
}
