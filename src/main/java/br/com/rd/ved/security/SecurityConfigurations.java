package br.com.rd.ved.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.rd.ved.repository.ClienteRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{

	@Autowired
	private AutencaticacaoService autenticacaoService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		.antMatchers(HttpMethod.POST,"/bandeira/*").permitAll()
		.antMatchers(HttpMethod.GET,"/bandeira/*").permitAll()
		.antMatchers(HttpMethod.POST,"/cliente/cartao/*").permitAll()
		.antMatchers(HttpMethod.GET,"/cliente/cartao/*").permitAll()
		.antMatchers(HttpMethod.POST,"/categoria/*").permitAll()
		.antMatchers(HttpMethod.GET,"/categoria/*").permitAll()
		.antMatchers(HttpMethod.POST,"/cliente/*").permitAll()
		.antMatchers(HttpMethod.GET,"/cliente/*").permitAll()
		.antMatchers(HttpMethod.POST,"/cupom/*").permitAll()
		.antMatchers(HttpMethod.GET,"/cupom/*").permitAll()
		.antMatchers(HttpMethod.POST,"/cliente/endereco/*").permitAll()
		.antMatchers(HttpMethod.GET,"/cliente/endereco/*").permitAll()
		.antMatchers(HttpMethod.POST,"/pagamento/*").permitAll()
		.antMatchers(HttpMethod.GET,"/pagamento/*").permitAll()
		.antMatchers(HttpMethod.POST,"/frete/*").permitAll()
		.antMatchers(HttpMethod.GET,"/frete/*").permitAll()
		.antMatchers(HttpMethod.POST,"/home/*").permitAll()
		.antMatchers(HttpMethod.GET,"/home/*").permitAll()
		.antMatchers(HttpMethod.POST,"/itemPedido/*").permitAll()
		.antMatchers(HttpMethod.GET,"/itemPedido/*").permitAll()
		.antMatchers(HttpMethod.POST,"/pedido/*").permitAll()
		.antMatchers(HttpMethod.GET,"/pedido/*").permitAll()
		.antMatchers(HttpMethod.POST,"/produto/*").permitAll()
		.antMatchers(HttpMethod.GET,"/produto/*").permitAll()
		.antMatchers(HttpMethod.POST,"/uf/*").permitAll()
		.antMatchers(HttpMethod.GET,"/uf/*").permitAll()
		.antMatchers(HttpMethod.POST,"/historico/*").permitAll()
		.antMatchers(HttpMethod.GET,"/historico/*").permitAll()
		.antMatchers(HttpMethod.POST,"/auth").permitAll()
		.anyRequest().authenticated()
		.and().cors().and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, clienteRepository), UsernamePasswordAuthenticationFilter.class);		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {

		
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
	
	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123"));
//	}
	
}
