package com.example.xinxilope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xinxilope.model.Pessoa;
import com.example.xinxilope.service.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping("/pessoa")
	public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.savePessoa(pessoa);
	}
	
	@GetMapping("/pessoa/{id}")
	public Pessoa getPessoa(@PathVariable("id") Long id) {
		return pessoaService.getPessoaById(id);
	}
	
	@GetMapping("/pessoa")
	public List<Pessoa> getAllPessoa(){
	 	return pessoaService.getAllPessoas();
	}
	
	@PutMapping("/pessoa/{id}")
	public Pessoa updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		return pessoaService.updatePessoa(id, pessoa);
	}
	
	@DeleteMapping("/pessoa/{id}")
	public String deletePessoa(@PathVariable("id") Long id) {
		return pessoaService.deletePessoa(id);
	}

}
