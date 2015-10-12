package model;

public abstract class Operand implements Tree {

	@Override
	public Tree getLeft() {
		return null;
	}

	@Override
	public Tree getRight() {
		return null;
	}

}
