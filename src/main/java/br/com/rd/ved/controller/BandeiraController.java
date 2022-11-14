package br.com.rd.ved.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.repository.BandeiraRepository;


@RestController
@RequestMapping("/bandeira")
public class BandeiraController {


	@Autowired
	private BandeiraRepository bandeiraRepository;

	
	@GetMapping
	public List <Bandeira> Listar() {
				List<Bandeira> bandeiras = bandeiraRepository.findAll();
	return bandeiras;
}
}
