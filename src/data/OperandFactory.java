package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import model.Constant;
import model.Variable;

public class OperandFactory {
	private Map<Variable, Integer> variables = new HashMap<Variable, Integer>();
	private Map<Integer, Constant> constants = new HashMap<Integer, Constant>();

	/**
	 * Private constructor.
	 */
	private OperandFactory() {

	}

	private static OperandFactory instance = new OperandFactory();

	public static OperandFactory getInstance() {
		return instance;
	}

	public Variable createVariable(String name, int initialValue) {		
		Variable variable = new Variable(name);
		variables.put(variable, initialValue);
		return variable;
	}

	public int getVariableValue(Variable variable) throws NoSuchElementException{
		if (variables.containsKey(variable)) {
			return variables.get(variable);
		} else {
			throw new NoSuchElementException("No such variable " + variable.getName());
		}
	}

	public Constant createConstant(int value) {
		if (constants.containsKey(value)) {
			return constants.get(value);
		} else {
			Constant constant = new Constant(value);
			constants.put(value, constant);
			return constant;
		}
	}

}
