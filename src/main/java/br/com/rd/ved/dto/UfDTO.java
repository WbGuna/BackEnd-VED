package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Uf;

public class UfDTO {

	private Integer id;
	private String nomeUf;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nomeUf;
	}

	public UfDTO(Uf uf) {
		this.id = uf.getId();
		this.nomeUf = uf.getDescricao();
	}

	public static List<UfDTO> converter(List<Uf> ufs) {
		return ufs.stream().map(UfDTO::new).collect(Collectors.toList());
	}

}
