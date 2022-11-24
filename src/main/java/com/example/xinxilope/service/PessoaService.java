package com.example.xinxilope.service;

import java.util.List;

import com.example.xinxilope.model.Pessoa;

public interface PessoaService {
	
	List<Pessoa> getAllPessoas();
	Pessoa getPessoaById(Long id);
	Pessoa savePessoa(Pessoa pessoa);
	String deletePessoa(Long id);
	Pessoa updatePessoa(Long id, Pessoa pessoa);
	

}
