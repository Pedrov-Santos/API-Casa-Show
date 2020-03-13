package com.example.demo.api.service.exception;


public class CasaNaoEncontradaException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6278067686158778103L;

		public CasaNaoEncontradaException(String mensagem) {
			super(mensagem);
		}
		
		public CasaNaoEncontradaException(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}

}
