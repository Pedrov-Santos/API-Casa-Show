package com.example.demo.api.service.exception;



	public class UserNaoEncontradoException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6278067686158778103L;

		public UserNaoEncontradoException(String mensagem) {
			super(mensagem);
		}
		
		public UserNaoEncontradoException(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}

	}
