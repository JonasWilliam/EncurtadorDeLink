package br.com.jonas.encurtador.Exception;

public class LinkException extends EntidadeNaoEncontradaException {

		private static final long serialVersionUID = 1L;

		public LinkException(String mensagem) {
			super(mensagem);
		}

		public LinkException(int id) {
			this(String.format("Não existe um cadastro de Link com id %d", id));
		}

	}
	
