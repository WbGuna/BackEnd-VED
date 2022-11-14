package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Frete;

public class FreteDTO {
	private Integer id;
	private BigDecimal valor;
	private String tipoFrete;
	
	
	public FreteDTO(Frete frete) {
		super();
		this.id = frete.getId();
		this.valor = frete.getValor();
		this.tipoFrete = frete.getTipoFrete().getDescricao();
	}


	public Integer getId() {
		return id;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public String getTipoFrete() {
		return tipoFrete;
	}

	public static List<FreteDTO> converter(List<Frete> frete) {
		return frete.stream().map(FreteDTO::new).collect(Collectors.toList());
	}
	
		
}
