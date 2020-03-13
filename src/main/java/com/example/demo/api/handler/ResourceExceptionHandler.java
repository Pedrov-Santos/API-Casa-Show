package com.example.demo.api.handler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.api.domain.DetalhesErros;
import com.example.demo.api.service.exception.CasaNaoEncontradaException;
import com.example.demo.api.service.exception.CompraNaoEncontradaException;
import com.example.demo.api.service.exception.EventoNaoEncontradoException;
import com.example.demo.api.service.exception.UserNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	DetalhesErros erro = new DetalhesErros();
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalhesErros> handlerConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
		
		erro.setStatus(404l);
		erro.setTitulo("Prencha todos os atributos nescessarios. ");
		erro.setMensagemErro("https://stackoverflow.com/");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<DetalhesErros> handlerEmptyResultDataAccessException(EmptyResultDataAccessException e, HttpServletRequest request){
		
		erro.setStatus(401l);
		erro.setTitulo("Codigo invalido");
		erro.setMensagemErro("https://stackoverflow.com/");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

@ExceptionHandler(NumberFormatException.class)
public ResponseEntity<DetalhesErros> handlerNumberFormatException(NumberFormatException e, HttpServletRequest request){
	
	erro.setStatus(402l);
	erro.setTitulo("Url invalida");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}


@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<DetalhesErros> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request){
	
	erro.setStatus(405l);
	erro.setTitulo("Verificar url, metodo ou dados");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
@ExceptionHandler(HttpMessageNotReadableException.class)
public ResponseEntity<DetalhesErros> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request){
	
	erro.setStatus(400l);
	erro.setTitulo("Verificar url ou metodo");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	} 


@ExceptionHandler(CasaNaoEncontradaException.class)
public ResponseEntity<DetalhesErros> handlerCasaNaoEncontradaException(CasaNaoEncontradaException e, HttpServletRequest request){
	
	erro.setStatus(500l);
	erro.setTitulo("Casa não encontrada.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

@ExceptionHandler(DataIntegrityViolationException.class)
public ResponseEntity<DetalhesErros> handlerDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
	
	erro.setStatus(501l);
	erro.setTitulo("Dados invalidos.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	} 

@ExceptionHandler(InvalidDataAccessApiUsageException.class)
public ResponseEntity<DetalhesErros> handlerInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e, HttpServletRequest request){
	
	erro.setStatus(502l);
	erro.setTitulo("Dados invalidos.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}  
@ExceptionHandler(EventoNaoEncontradoException.class)
public ResponseEntity<DetalhesErros> handlerEventoNaoEncontradoException(EventoNaoEncontradoException e, HttpServletRequest request){
	
	erro.setStatus(503l);
	erro.setTitulo("Evento não encontrado.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	} 

@ExceptionHandler(CompraNaoEncontradaException.class)
public ResponseEntity<DetalhesErros> handlerCompraNaoEncontradaException(CompraNaoEncontradaException e, HttpServletRequest request){
	
	erro.setStatus(503l);
	erro.setTitulo("Compra não encontrada.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	} 

@ExceptionHandler(UserNaoEncontradoException.class)
public ResponseEntity<DetalhesErros> handlerUserNaoEncontradoException(UserNaoEncontradoException e, HttpServletRequest request){
	
	erro.setStatus(503l);
	erro.setTitulo("User não encontrado.");
	erro.setMensagemErro("https://stackoverflow.com/");
	erro.setTimestamp(System.currentTimeMillis());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}



