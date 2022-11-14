package br.com.rd.ved.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.BoletoDTO;
import br.com.rd.ved.dto.PagamentoCartaoDto;
import br.com.rd.ved.dto.PixDTO;
import br.com.rd.ved.formdto.BoletoForm;
import br.com.rd.ved.formdto.PagamentoCartaoForm;
import br.com.rd.ved.model.Boleto;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Pix;
import br.com.rd.ved.repository.BoletoRepository;
import br.com.rd.ved.repository.CartaoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PixRepository;

@RestController
@RequestMapping("/pagamento")
public class FormaPagamentoController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private PixRepository pixRepository;
	
	@Autowired
	private BoletoRepository boletoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
		
	@GetMapping("/pix/{id}")
	public ResponseEntity<PixDTO> pagaPix() {
		System.err.println();
		Optional<Pix> pix = pixRepository.findById(1);	
		if (pix.isPresent()) {
			return ResponseEntity.ok().body(new PixDTO(pix.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	@PostMapping("/boleto")
	public ResponseEntity<BoletoDTO> pagaBoleto(@RequestBody @Valid BoletoForm boletoForm,
			UriComponentsBuilder uriBuilder) {
		Boleto boleto = boletoForm.converter(boletoRepository);
		boletoRepository.save(boleto);
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(boleto.getId()).toUri();
		return ResponseEntity.created(uri).body(new BoletoDTO(boleto));
	}
	
	@GetMapping("/boleto/{id}")
	public ResponseEntity<BoletoDTO> buscarBoleto(@PathVariable("id") Integer id ){
		Optional<Boleto> boleto = boletoRepository.findById(id);
		
		if (boleto.isPresent()) {
			return ResponseEntity.ok().body(new BoletoDTO(boleto.get()));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping("/parcelas/{id}/{idPedido}")
	public ResponseEntity<PagamentoCartaoDto> valorParcelas(@PathVariable("id") Integer id,
			@PathVariable("idPedido") Integer idPedido,
			@RequestBody @Valid PagamentoCartaoForm Form){

		Optional<Cartao> cartao = cartaoRepository.findById(id);
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		
		return ResponseEntity.ok().body(new PagamentoCartaoDto(Form, cartao.get(), pedido.get().getId()));	
	}
		
	

}
	
