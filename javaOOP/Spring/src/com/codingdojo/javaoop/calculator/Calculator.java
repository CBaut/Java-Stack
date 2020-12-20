package com.codingdojo.javaoop.calculator;

public class Calculator implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double operandOne = 0.0;
	private String operation = "";
	private Double OperandTwo = 0.0;
	private Double results = 0.0;
	
	
	public Calculator() {
//		
	}
	public Calculator(Double operandOne, String operation, Double operandTwo) {
		this.operandOne = operandOne;
		this.OperandTwo = operandTwo;
		this.operation = operation;
	}
//	make getters and setters
	public Double getOperandOne() {
		return this.operandOne;
	}
	public void setOperandOne(Double one) {
		this.operandOne = one;
	}
	public Double getOperandTwo() {
		return this.OperandTwo;
	}
	public void setOperandTwo(Double two) {
		this.OperandTwo = two;
	}
	public String getOperation() {
		return this.operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void performOperation() {
		if(this.getOperandOne() == null || this.getOperandTwo() == null) {
			System.out.println("Can't perform operation because one of the operands is missing");
			return;
		}
		if(this.getOperation() == "+") {
			System.out.println("We are adding " + this.getOperandOne() + " and " + this.getOperandTwo());
			this.setResults(this.getOperandOne() + this.getOperandTwo());
		} else if(this.getOperation() == "-") {
			System.out.println("We are subtracting " + this.getOperandOne() + " and " + this.getOperandTwo());
			this.setResults(this.getOperandOne() - this.getOperandTwo());
		} else {
			System.out.println("Invalid operation.. + and - supported only");
			return;
		}
	}
	
	public Double getResults() {
//		
		return this.results;
	}
	public void setResults(Double results) {
		this.results = results;
	}
}
