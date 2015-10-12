package model;

import engine.TreeVisitor;

public interface Tree {
	Tree getLeft();

	Tree getRight();
	
	int calculate();

	<T> T accept(TreeVisitor<T> visitor);
}
