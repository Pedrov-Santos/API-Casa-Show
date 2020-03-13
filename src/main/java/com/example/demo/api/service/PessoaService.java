package com.example.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.service.exception.UserNaoEncontradoException;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repositoryPessoa;
	
	public List<Pessoa> listarUser(){
		return repositoryPessoa.findAll();
	}
	
	public Pessoa salvarUser(Pessoa user) {
		user.setCodigo(null);
		return repositoryPessoa.save(user);
	}
	
	public Optional<Pessoa> buscarUser(Long codigo) {
		Optional<Pessoa> user = repositoryPessoa.findById(codigo);
		if(user.isPresent()) {
			return user;
		}
		throw new UserNaoEncontradoException("");
		
	}
}
