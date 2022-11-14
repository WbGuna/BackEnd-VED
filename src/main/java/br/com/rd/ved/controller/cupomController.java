package br.com.rd.ved.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.repository.CupomDescontoRepository;

@RestController
@RequestMapping("/cupom")
public class cupomController {

	@Autowired
	private CupomDescontoRepository cupomRepositor;

	@GetMapping("/{buscar}")
	public CupomDesconto buscaCupom(@PathVariable("buscar") String cupomNome) {
		Optional< CupomDesconto > cupoms = cupomRepositor.cupomPorNome(cupomNome);

		return cupoms.get();
	}

}
