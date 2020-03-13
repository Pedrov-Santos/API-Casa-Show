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

import com.example.demo.api.service.CasasServices;
import com.example.demo.model.CasaShow;

import io.swagger.annotations.Api;

@Api(tags = "Casas")
@RestController
@RequestMapping("/api/casas")
public class CasasResource {
	
		@Autowired
		private CasasServices serviceCasa;

		@GetMapping
		public ResponseEntity<List<CasaShow>> listarCasas(){
			
			return ResponseEntity.status(HttpStatus.OK).body(serviceCasa.listarCasas());
			
		}
		
		@PostMapping
		public ResponseEntity<Void> salvar(@RequestBody CasaShow casa){
			
			casa = serviceCasa.salvarCasa(casa);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(casa.getCodigo()).toUri();
			
			return ResponseEntity.created(uri).build();
			
		}
		
		@GetMapping(value = "/{codigo}")
		public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo) {
			
			Optional<CasaShow> casa = serviceCasa.buscar(codigo);
			return ResponseEntity.status(HttpStatus.OK).body(casa);	
		}
		
		@PutMapping(value = "/{codigo}")
		public ResponseEntity<CasaShow> editar(@RequestBody CasaShow casa , @PathVariable ("codigo") Long codigo) {
			
			casa.setCodigo(codigo);
			serviceCasa.editar(casa);
			return ResponseEntity.status(HttpStatus.OK).body(casa);
		}
		
		
		@DeleteMapping(value = "/{codigo}")
		public ResponseEntity<Void> deletarCasa(@PathVariable("codigo") Long codigo) {
			
			serviceCasa.deletar(codigo);
			return ResponseEntity.noContent().build();
		}
		
		@GetMapping(value="/asc")
		public ResponseEntity<List<CasaShow>> listarOrdemCrescente() {
			return ResponseEntity.status(HttpStatus.OK).body(serviceCasa.listarOrdemCrescente());
		}

		
		@GetMapping(value="/desc")
		public ResponseEntity<List<CasaShow>> listarOrdemDecrescente() {
			return ResponseEntity.status(HttpStatus.OK).body(serviceCasa.listarOrdemDecrescente());
		}
		
		@GetMapping(value = "/nomecasa/{nomeCasa}")
		public ResponseEntity<?> buscar(@PathVariable("nomeCasa") String nomeCasa) {
			
			CasaShow casa = serviceCasa.buscarNomeCasa(nomeCasa);
			return ResponseEntity.status(HttpStatus.OK).body(casa);	
		}
}




