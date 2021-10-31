package main.java.project.exception;

public class DelimitadorInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

	public DelimitadorInvalidoException() {

		super("O delimitador nao pode ser uma string");
        
	}
}