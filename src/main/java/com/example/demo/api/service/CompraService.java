package com.example.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.service.exception.CompraNaoEncontradaException;
import com.example.demo.model.Compra;
import com.example.demo.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository repositoryCompra;
	
	public List<Compra> listarCompras(){
		return repositoryCompra.findAll();
	}
	
	public Optional<Compra> buscar(Long codigo) {
		Optional<Compra> compra = repositoryCompra.findById(codigo);
		if(compra.isPresent()) {
			return compra;
		}
		throw new CompraNaoEncontradaException("Compra não encontrada.");
		
	}
}
