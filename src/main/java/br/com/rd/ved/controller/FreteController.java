package br.com.rd.ved.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rd.ved.dto.FreteDTO;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.repository.FreteRepository;

@RestController
@RequestMapping(value = "/frete")
public class FreteController {

	@Autowired
	private FreteRepository freterepository;

	@GetMapping("/{uf}")
	public List<FreteDTO> filtroPorTipoFrete(@PathVariable("uf") Integer tipo) {
		List<Frete> frete = freterepository.findFretePorTipo(tipo);

		return FreteDTO.converter(frete);
	}
}