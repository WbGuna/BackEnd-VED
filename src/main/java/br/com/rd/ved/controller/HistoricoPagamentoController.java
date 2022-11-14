package br.com.rd.ved.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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

import br.com.rd.ved.dto.HistoricoPagamentoDTO;
import br.com.rd.ved.formdto.HistoricoPagamentoForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.HistoricoPagamento;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.BoletoRepository;
import br.com.rd.ved.repository.CartaoRepository;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.HistoricoPagamentoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PixRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoPagamentoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PixRepository pixRepository;
	
	@Autowired
	private BoletoRepository boletoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private HistoricoPagamentoRepository historicoPagamentoRepository;

	
	@GetMapping("/{id}/detalhes")
	public List<HistoricoPagamentoDTO> listar(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<HistoricoPagamento> historicos = cliente.get().getHistoricoPagamento(); 
		return HistoricoPagamentoDTO.converter(historicos);
	}
		
		
	@PostMapping("/novo")
	@Transactional
	public ResponseEntity<HistoricoPagamentoDTO> cadastrar(@RequestBody @Valid HistoricoPagamentoForm historicoForm, UriComponentsBuilder uriBuilder) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(historicoForm.getPedido());
		
		HistoricoPagamento historico = historicoForm.converter(pedidoRepository, 
															   clienteRepository, 
															   pixRepository,
															   boletoRepository,
															   cartaoRepository);
		historicoPagamentoRepository.save(historico);
		historicoForm.cadastrarHistorico(historico, pedido.get(), historicoPagamentoRepository);
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(historico.getId()).toUri();
		return ResponseEntity.created(uri).body(new HistoricoPagamentoDTO(historico));

	}	
		
		
		
		
		
}

	
	
	
	
	