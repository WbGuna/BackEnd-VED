package br.com.rd.ved.formdto;


import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.rd.ved.dto.CartaoDTO;
import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.BandeiraRepository;
import br.com.rd.ved.repository.ClienteRepository;


public class ClienteCartaoForm {

		@NotNull
		@NotEmpty
		private String numeroCartao;
		@NotNull
		@NotEmpty
		private String nomeTitular;
		@NotNull
		@NotEmpty
		private String cpfTitular;
		@NotNull
		@NotEmpty
		private Integer diaVencimento;
		@NotNull
		@NotEmpty
		private Integer anoVencimento;
		@NotNull
		@NotEmpty
		private Integer idBandeira;
		
	
		
		public String getNumeroCartao() {
			return numeroCartao;
		}

		public void setNumeroCartao(String numeroCartao) {
			this.numeroCartao = numeroCartao;
		}

		public void setNomeTitular(String nomeTitular) {
			this.nomeTitular = nomeTitular;
		}

		public void setCpfTitular(String cpfTitular) {
			this.cpfTitular = cpfTitular;
		}

		public void setDiaVencimento(Integer diaVencimento) {
			this.diaVencimento = diaVencimento;
		}

		public void setAnoVencimento(Integer anoVencimento) {
			this.anoVencimento = anoVencimento;
		}

		public void setIdBandeira(Integer idBandeira) {
			this.idBandeira = idBandeira;
		}
		
		
		public ClienteCartaoForm( String numeroCartao,  String nomeTitular,
				 String cpfTitular,  String diaVencimento,  String anoVencimento,
				 String idBandeira) {
			super();
			this.numeroCartao = numeroCartao;
			this.nomeTitular = nomeTitular;
			this.cpfTitular = cpfTitular;
			this.diaVencimento = Integer.parseInt(diaVencimento);
			this.anoVencimento = Integer.parseInt(anoVencimento);
			this.idBandeira = Integer.parseInt(idBandeira);
		}

		public Cartao converter(BandeiraRepository bandeiraRepository) {
			Optional<Bandeira> bandeira = bandeiraRepository.findById(this.idBandeira);
			Cartao cartao = new Cartao(numeroCartao, nomeTitular, cpfTitular, diaVencimento, anoVencimento, bandeira.get() );
			cartao.setBandeiraId(bandeira.get());
			return cartao;
		}
		
		public List<CartaoDTO> cadastrarCartao(Cartao cartao, Cliente cliente, ClienteRepository clienteRepository) {
			List<Cartao> cartoes;
			cartoes = cliente.getCartoes();
			cartoes.add(cartao);
			cliente.setCartoes(cartoes);
			clienteRepository.save(cliente);
			return CartaoDTO.converter(cartoes);
		
		    
		    

		}
	}
