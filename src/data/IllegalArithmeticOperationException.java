package data;


public class IllegalArithmeticOperationException extends Exception {

	private static final long serialVersionUID = -2279458111993737115L;

	public IllegalArithmeticOperationException(char type) {
		super("The operation" + type + "is not allowed!");
	}

}
