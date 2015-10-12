package engine;

import model.Addition;
import model.Operation;
import model.Constant;
import model.Multiplication;
import model.Subtraction;
import model.Variable;

public class HeigtVisitor implements TreeVisitor<Void> {
	private int height = 0;
	private int currentHeight = 0;

	public int getHeight() {
		return height;
	}

	public void setDeepest(int deepest) {
		this.height = deepest;
	}

	@Override
	public Void visit(Constant operation) {
		if (height < currentHeight) {
			height = currentHeight;
		}
		return null;
	}

	@Override
	public Void visit(Variable operation) {
		if (height < currentHeight) {
			height = currentHeight;
		}
		return null;
	}

	@Override
	public Void visit(Addition operation) {
		processArithmeticOperation(operation);
		return null;
	}

	@Override
	public Void visit(Subtraction operation) {
		processArithmeticOperation(operation);
		return null;
	}

	@Override
	public Void visit(Multiplication operation) {
		processArithmeticOperation(operation);
		return null;
	}

	private void processArithmeticOperation(Operation operation) {
		currentHeight++;
		operation.getLeft().accept(this);
		operation.getRight().accept(this);
		currentHeight--;
	}

}
