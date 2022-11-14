package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Receita;

public class ReceitaDTO {

	private String titulo;
	private String ingredientes;
	private String preparo;

	public ReceitaDTO(Receita receita) {
		this.titulo = receita.getNome();
		this.ingredientes = receita.getIngredientes();
		this.preparo = receita.getPreparo();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public String getPreparo() {
		return preparo;
	}

	public static List<ReceitaDTO> converter(List<Receita> receita) {
		return receita.stream().map(ReceitaDTO::new).collect(Collectors.toList());
	}

}
