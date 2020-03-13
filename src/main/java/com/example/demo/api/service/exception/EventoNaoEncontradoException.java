package com.example.demo.api.service.exception;


public class EventoNaoEncontradoException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6278067686158778103L;

		public EventoNaoEncontradoException(String mensagem) {
			super(mensagem);
		}
		
		public EventoNaoEncontradoException(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}

}
