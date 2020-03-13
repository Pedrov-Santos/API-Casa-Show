package com.example.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.api.service.exception.EventoNaoEncontradoException;
import com.example.demo.model.NovoShow;
import com.example.demo.repository.Shows;

@Service
public class EventoService {
	
	@Autowired
	private Shows repositoryEventos;
	
	public List<NovoShow> listarEventos(){
		return repositoryEventos.findAll();
	}
	
	public NovoShow salvarEvento(NovoShow evento) {
		evento.setCodigo(null);
		return repositoryEventos.save(evento);
	}
	
	public void deletarEvento(Long codigo) {
		
		try {
			repositoryEventos.deleteById(codigo);
			} catch (EmptyResultDataAccessException e) {
			throw new EventoNaoEncontradoException("");
		}
	}
	
	public Optional<NovoShow> buscarEvento(Long codigo) {
		Optional<NovoShow> evento = repositoryEventos.findById(codigo);
		if(evento.isPresent()) {
			return evento;
		}
		throw new EventoNaoEncontradoException("");
		
	}
	
	public void editar(NovoShow evento) {
		verificarExistencia(evento);
		repositoryEventos.save(evento);
		 
		
	}
	
	private void verificarExistencia(NovoShow evento) {
		buscarEvento(evento.getCodigo());
	}
	
	
	/////////////////////// ASC ////////////////////////////
	public List<NovoShow> listarOrdemCrescenteNome(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.ASC,"nomeEvento"));
	}
	
	public List<NovoShow> listarOrdemCrescenteCapacidade(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.ASC,"capacidadeEvento"));
	}
	
	public List<NovoShow> listarOrdemCrescenteValor(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.ASC,"valorEvento"));
	}
	
	public List<NovoShow> listarOrdemCrescenteData(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.ASC,"dataEvento"));
	}
	
	
	////////////////////// DESC ///////////////////////////////
	public List<NovoShow> listarOrdemDecrescenteNome(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.DESC,"nomeEvento"));
	}
	
	public List<NovoShow> listarOrdemDecrescenteCapacidade(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.DESC,"capacidadeEvento"));
	}
	
	public List<NovoShow> listarOrdemDecrescenteValor(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.DESC,"valorEvento"));
	}
	
	public List<NovoShow> listarOrdemDecrescenteData(){
		return repositoryEventos.findAll(Sort.by(Sort.Direction.DESC,"dataEvento"));
	}
}
