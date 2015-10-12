package model;

public abstract class Operation implements Tree {
	private Tree left;
	private Tree right;

	public Operation(Tree left, Tree right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Tree getLeft() {
		return left;
	}

	@Override
	public Tree getRight() {
		return right;
	}

}
