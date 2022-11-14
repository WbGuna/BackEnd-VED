package br.com.rd.ved.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

@Service
public class AutencaticacaoService implements UserDetailsService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Cliente> cliente = clienteRepository.findByEmail(username);
		
		if(cliente.isPresent()) {
			return cliente.get();
		} 
		
		throw new UsernameNotFoundException("Usuario incorreto!");
	}

}
