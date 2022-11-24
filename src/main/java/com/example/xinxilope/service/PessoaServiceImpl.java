package com.example.xinxilope.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xinxilope.model.Pessoa;
import com.example.xinxilope.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Pessoa getPessoaById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) return pessoa.get();
		return null;
	}

	@Override
	public List<Pessoa> getAllPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoaRepository.findAll().forEach(pessoa -> pessoas.add(pessoa));
		return pessoas;
	}
	
	@Override
	public Pessoa updatePessoa(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaById = pessoaRepository.findById(id);
		
		if(pessoaById.isPresent()) {
			Pessoa updatedPessoa = pessoaById.get();
		
			updatedPessoa.setId(pessoa.getId());
			updatedPessoa.setNome(pessoa.getNome());
			updatedPessoa.setSobrenome(pessoa.getSobrenome());
			updatedPessoa.setCpf(pessoa.getCpf());
			updatedPessoa.setRg(pessoa.getRg());
			
			return pessoaRepository.save(updatedPessoa);
		}
		
		return null;
	}

	@Override
	public String deletePessoa(Long id) {
		pessoaRepository.deleteById(id);
		return "id" + id + "is deleted successfully"; 
	}
}
