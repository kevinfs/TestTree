package model;

import engine.TreeVisitor;

public class Subtraction extends Operation {

	public Subtraction(Tree left, Tree right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return getLeft().toString() + " - " + getRight().toString();
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int calculate() {
		return getLeft().calculate() - getRight().calculate();
	}

}
