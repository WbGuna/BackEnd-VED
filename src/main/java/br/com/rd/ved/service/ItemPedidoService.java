package br.com.rd.ved.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.PK.PedidoIntemPedidoCH;
import br.com.rd.ved.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Transactional(readOnly = true)
	public List<ItemPedidoDTO> findAll() {
		List<ItemPedido> list = itemPedidoRepository.findAll();
		return list.stream().map(x -> new ItemPedidoDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public ItemPedidoDTO insert(ItemPedidoForm form) {
		ItemPedido entity = new ItemPedido();
		PedidoIntemPedidoCH id = new PedidoIntemPedidoCH();
		id.setPedido(Integer.parseInt(form.getPedido()));
		id.setProduto(Integer.parseInt(form.getProduto()));
		entity.setIdch(id);
		entity.setQuantidade(Integer.parseInt(form.getQuantidade()));
		entity.setPorcentagemIcms(Double.parseDouble(form.getPorcentagemIcms()));
		entity.setValorIcms(Double.parseDouble(form.getValorIcms()));
		entity = itemPedidoRepository.save(entity);
		return new ItemPedidoDTO(entity);
	}

}
