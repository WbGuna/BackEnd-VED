package br.com.rd.ved.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.UfDTO;
import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.UfRepository;

@RestController
@RequestMapping("/uf")
public class UfController { 
	
	@Autowired
	private UfRepository ufRepository; 
	
	
	@GetMapping
	public List<UfDTO> listar(){
		List<Uf> ufs = ufRepository.findAll();
		return UfDTO.converter(ufs);
	}
	
}