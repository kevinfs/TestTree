package model;

import engine.TreeVisitor;

public class Constant extends Operand {
	private int value;

	public Constant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int calculate() {
		return value;
	}

}
