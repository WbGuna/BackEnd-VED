package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Boleto;


public class BoletoDTO {

	
	private Integer id;
	private String codigoBarras;

	public Integer getId() {
		return id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public BoletoDTO(Boleto boleto) {
		this.id = boleto.getId();
		this.codigoBarras = boleto.getCodigoBarras();
	}

	public static List<BoletoDTO> converter(List<Boleto> boletos) {
		return boletos.stream().map(BoletoDTO::new).collect(Collectors.toList());
	}
}	
	
	
