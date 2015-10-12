package data;

import model.*;

public class OperationFactory {

	public static Operation create(char type, Tree leftOperand, Tree rightOperand) throws IllegalArithmeticOperationException {
		switch (type) {
		case '+':
			return new Addition(leftOperand, rightOperand);
		case '-':
			return new Subtraction(leftOperand, rightOperand);
		case '*':
			return new Multiplication(leftOperand, rightOperand);
		default:
			throw new IllegalArithmeticOperationException(type);
		}

	}

}
