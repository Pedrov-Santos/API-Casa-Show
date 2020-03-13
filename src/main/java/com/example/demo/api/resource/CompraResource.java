package com.example.demo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.service.CompraService;
import com.example.demo.model.Compra;

import io.swagger.annotations.Api;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/api/compra")
public class CompraResource {

	@Autowired
	private CompraService serviceCompra;
	
	@GetMapping
	public ResponseEntity<List<Compra>> listarCasas(){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceCompra.listarCompras());
		
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo) {
		
		Optional<Compra> compra = serviceCompra.buscar(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(compra);	
	}
}
