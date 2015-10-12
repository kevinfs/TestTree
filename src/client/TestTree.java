package client;

import java.util.List;
import java.util.NoSuchElementException;

import model.*;

import data.IllegalArithmeticOperationException;
import data.OperandFactory;
import data.OperationFactory;
import engine.HeigtVisitor;
import engine.SearchConstantVisitor;
import engine.SearchVariableVisitor;
import engine.TreeVisitor;

public class TestTree {

	public static void main(String[] args) {

		try {
			Tree tree = createTree();

			testConstantVisitor(tree);

			testVariableVisitor(tree);

			testHeightVisitor(tree);
			
			testCalculate(tree);

		} catch (IllegalArithmeticOperationException e) {
			System.err.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void testHeightVisitor(Tree tree) {
		HeigtVisitor heightVisitor = new HeigtVisitor();
		tree.accept(heightVisitor);
		System.out.println("The height of the tree is " + heightVisitor.getHeight());
	}

	private static void testVariableVisitor(Tree tree) {
		TreeVisitor<List<Variable>> searchVariableVisitor = new SearchVariableVisitor();

		List<Variable> resultsVariable = tree.accept(searchVariableVisitor);
		System.out.println("- All found variables : ");
		for (Variable variable : resultsVariable) {
			System.out.println("Variable " + variable.getName());
		}
	}

	private static void testConstantVisitor(Tree tree) {
		TreeVisitor<List<Constant>> searchConstantVisitor = new SearchConstantVisitor();
		List<Constant> results = tree.accept(searchConstantVisitor);
		System.out.println("- All found constants : ");
		for (Constant constant : results) {
			System.out.println("Constant " + constant.getValue());
		}
	}

	private static void testCalculate(Tree tree) {
		String formulaString = tree.toString();
		int calculationResult = tree.calculate();
		System.out.println("The result of the formula " + formulaString + " is : " + calculationResult);
	}

	public static Tree createTree() throws IllegalArithmeticOperationException, NoSuchElementException {
		OperandFactory operandFactory = OperandFactory.getInstance();
		Constant c1 = operandFactory.createConstant(2);
		Constant c2 = operandFactory.createConstant(3);
		Constant c3 = operandFactory.createConstant(4);

		Variable vX = operandFactory.createVariable("X", 1);
		Variable vY = operandFactory.createVariable("Y", 2);
		Variable vZ = operandFactory.createVariable("Z", 3);

		Operation term1 = OperationFactory.create('*', c1, vX);
		Operation term2 = OperationFactory.create('*', c2, vY);
		Operation term3 = OperationFactory.create('+', term1, term2);
		Operation term4 = OperationFactory.create('*', c3, vZ);
		Operation root = OperationFactory.create('-', term3, term4);
		return root;
	}

}
