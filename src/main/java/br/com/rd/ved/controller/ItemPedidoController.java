package br.com.rd.ved.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.dto.ItemPedidoDetalheDTO;
import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.service.ItemPedidoService;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoService itemService;

	@GetMapping
	public ResponseEntity<List<ItemPedidoDTO>> findAll() {
		List<ItemPedidoDTO> list = itemService.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping("/novo")
	public ResponseEntity<ItemPedidoDTO> insert(@RequestBody List<ItemPedidoForm> form) {

		for(int i = 0; i < form.size(); i++) {	
			System.out.println(i);
			ItemPedidoDTO entity = itemService.insert(form.get(i));	
			System.out.println(entity);
		}
		return null;


	
}

	@GetMapping("/pedido={id}/items")
	public ResponseEntity<List<ItemPedidoDetalheDTO>> visualizar(@PathVariable("id") Integer id) {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (pedido.isPresent()) {
			List<ItemPedido> itemPedido;
			itemPedido = pedido.get().getItemPedidos();
			return ResponseEntity.ok().body(ItemPedidoDetalheDTO.converter(itemPedido));
		}
		return ResponseEntity.notFound().build();
	}

}
