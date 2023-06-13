package model.exceptions;

public class DomainExcepetions extends RuntimeException{ // melhor usar do que "Exception" pois não precisa tratar com o Throws

	private static final long serialVersionUID = 1L;
	
	public DomainExcepetions (String msg) { // CONSTRUTOR COM STRING COMO ARGUMENTO
		super(msg);  
	}
	

}
