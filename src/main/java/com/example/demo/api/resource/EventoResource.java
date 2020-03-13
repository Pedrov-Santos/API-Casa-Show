package com.example.demo.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.api.service.EventoService;
import com.example.demo.model.NovoShow;

import io.swagger.annotations.Api;

@Api(tags = "Eventos")
@RestController
@RequestMapping("/api/eventos")
public class EventoResource {

	@Autowired
	private EventoService serviceEventos;
	
	@GetMapping
	public ResponseEntity<List<NovoShow>> listarEventos(){
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarEventos());
	}
	
	@PostMapping
	public ResponseEntity<Void> salvarEvento(@RequestBody NovoShow evento){
		
		evento = serviceEventos.salvarEvento(evento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> deletarEvento(@PathVariable("codigo") Long codigo){
		
		serviceEventos.deletarEvento(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<?> buscarEvento(@PathVariable("codigo") Long codigo) {
		
		Optional<NovoShow> evento = serviceEventos.buscarEvento(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(evento);	
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<NovoShow> editar(@RequestBody NovoShow evento , @PathVariable ("codigo") Long codigo) {
		
		evento.setCodigo(codigo);
		serviceEventos.editar(evento);
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}
	
	@GetMapping(value="nomeevento/asc")
	public ResponseEntity<List<NovoShow>> listarOrdemCrescenteNome() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemCrescenteNome());
	}
	
	@GetMapping(value="capacidade/asc")
	public ResponseEntity<List<NovoShow>> listarOrdemCrescenteCapcidade() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemCrescenteCapacidade());
	}
	
	@GetMapping(value="data/asc")
	public ResponseEntity<List<NovoShow>> listarOrdemCrescenteData() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemCrescenteData());
	}
	
	@GetMapping(value="valor/asc")
	public ResponseEntity<List<NovoShow>> listarOrdemCrescenteValor() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemCrescenteValor());
	}
	
	@GetMapping(value="noveevento/desc")
	public ResponseEntity<List<NovoShow>> listarOrdemDecrecenteNome() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemDecrescenteNome());
	}
	
	@GetMapping(value="capacidade/desc")
	public ResponseEntity<List<NovoShow>> listarOrdemDecrecenteCapacidade() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemDecrescenteCapacidade());
	}
	
	@GetMapping(value="data/desc")
	public ResponseEntity<List<NovoShow>> listarOrdemDecrecenteData() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemDecrescenteData());
	}
	
	@GetMapping(value="valor/desc")
	public ResponseEntity<List<NovoShow>> listarOrdemDecrecenteValor() {
		return ResponseEntity.status(HttpStatus.OK).body(serviceEventos.listarOrdemDecrescenteValor());
	}
	
	
	
}
