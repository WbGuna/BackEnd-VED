package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.Pix;

public class PixDTO {

	@SuppressWarnings("unused")
	private Integer id;
	private String codigoPix;
	private String img;
	
	public PixDTO(Pix pix) {
		this.id = pix.getId();
		this.codigoPix = pix.getCodigoPix();
		this.img = pix.getImg();
	}


	public String getCodigoPix() {
		return codigoPix;
	}
	
	public String getImg() {
		return img;
	}

	public static List<PixDTO> converter(List<Pix> pixs) {
		return pixs.stream().map(PixDTO::new).collect(Collectors.toList());
	}
}