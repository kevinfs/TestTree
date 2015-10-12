package engine;

import java.util.ArrayList;
import java.util.List;

import model.*;


/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class SearchConstantVisitor implements TreeVisitor<List<Constant>> {

	@Override
	public List<Constant> visit(Constant operation) {
		List<Constant> results = new ArrayList<Constant>();
		results.add(operation);
		return results;
	}

	@Override
	public List<Constant> visit(Variable operation) {
		return new ArrayList<Constant>();
	}

	@Override
	public List<Constant> visit(Addition operation) {
		return processArithmeticOperation(operation);

	}

	private List<Constant> processArithmeticOperation(Operation operation) {
		List<Constant> leftResult = operation.getLeft().accept(this);
		List<Constant> rightResult = operation.getRight().accept(this);
		leftResult.addAll(rightResult);
		return leftResult;
	}

	@Override
	public List<Constant> visit(Subtraction operation) {
		return processArithmeticOperation(operation);
	}

	@Override
	public List<Constant> visit(Multiplication operation) {
		return processArithmeticOperation(operation);
	}

}
