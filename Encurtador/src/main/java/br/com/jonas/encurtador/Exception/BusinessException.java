package br.com.jonas.encurtador.Exception;

public class BusinessException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public BusinessException() {
	        super();
	    }

	    public BusinessException(String message){
	        super(message);
	    }

	    public BusinessException(String message, Throwable causa) {
	        super(message, causa);
	    }

	
	
}
