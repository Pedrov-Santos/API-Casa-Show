package com.example.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import com.example.demo.api.service.exception.CasaNaoEncontradaException;
import com.example.demo.model.CasaShow;
import com.example.demo.repository.Casas;

@Service
public class CasasServices {

	@Autowired
	private Casas repositoryCasas;
	
	public List<CasaShow> listarCasas(){
		return repositoryCasas.findAll();
	}
	
	public CasaShow salvarCasa(CasaShow casa) {
		
		casa.setCodigo(null);
		return repositoryCasas.save(casa);
		
	}
	
	public void deletar(Long codigo) {
		try {
			repositoryCasas.deleteById(codigo);
			} catch (EmptyResultDataAccessException e) {
			throw new CasaNaoEncontradaException("");
		}
		
		
	}
	
	public Optional<CasaShow> buscar(Long codigo) {
		Optional<CasaShow> casa = repositoryCasas.findById(codigo);
		if(casa.isPresent()) {
			return casa;
			
		}
		throw new CasaNaoEncontradaException("Casa não encontrada.");
	}
	
	public void editar(CasaShow casa) {
		verificarExistencia(casa);
		repositoryCasas.save(casa);
		 
		
	}
	
	private void verificarExistencia(CasaShow casa) {
		buscar(casa.getCodigo());
	}
	
	public List<CasaShow> listarOrdemCrescente(){
		return repositoryCasas.findAll(Sort.by(Sort.Direction.ASC,"nomeCasa"));
	}
	
	public List<CasaShow> listarOrdemDecrescente(){
		return repositoryCasas.findAll(Sort.by(Sort.Direction.DESC,"nomeCasa"));
	}
	
	public CasaShow buscarNomeCasa(String nomeCasa) {
		CasaShow casa = repositoryCasas.findByNomeCasa(nomeCasa);
		if(casa== null) {
			throw new CasaNaoEncontradaException("Casa não encontrada.");
		}
		
		return casa;
	}
}

