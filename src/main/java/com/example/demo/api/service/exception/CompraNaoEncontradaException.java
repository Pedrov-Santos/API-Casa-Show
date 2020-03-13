package com.example.demo.api.service.exception;

public class CompraNaoEncontradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6278067686158778103L;

	public CompraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CompraNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
