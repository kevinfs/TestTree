package model;

import data.OperandFactory;
import engine.TreeVisitor;

public class Variable extends Operand {
	private String name;

	public Variable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int calculate() {
		OperandFactory variableRepository = OperandFactory.getInstance();
		return variableRepository.getVariableValue(this);
	}

}
