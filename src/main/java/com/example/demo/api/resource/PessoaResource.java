package com.example.demo.api.resource;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.api.service.PessoaService;
import com.example.demo.model.Pessoa;

import io.swagger.annotations.Api;

@Api(tags = "Usuários")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaResource {

	
	@Autowired
	private PessoaService servicePessoa;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarEventos(){
		return ResponseEntity.status(HttpStatus.OK).body(servicePessoa.listarUser());
	}
	
	@PostMapping
	public ResponseEntity<Void> salvarUser(@RequestBody Pessoa user){
		
		user = servicePessoa.salvarUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<?> buscarUser(@PathVariable("codigo") Long codigo) {
		
		Optional<Pessoa> user = servicePessoa.buscarUser(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(user);	
	}
}
