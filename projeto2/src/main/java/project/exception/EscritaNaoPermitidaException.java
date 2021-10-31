package main.java.project.exception;

public class EscritaNaoPermitidaException extends Exception {

    private static final long serialVersionUID = 1L;

	public EscritaNaoPermitidaException() {

		super("Nao eh permitida escrita neste diretorio");
        
	}
}