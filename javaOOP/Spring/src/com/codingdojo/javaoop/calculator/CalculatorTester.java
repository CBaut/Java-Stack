package com.codingdojo.javaoop.calculator;

public class CalculatorTester {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setOperandOne(35.2);
		calculator.setOperandTwo(21.2);
		calculator.setOperation("+");
		calculator.performOperation();
		Double calc1Results = calculator.getResults();
		System.out.println(calc1Results);
		
		Calculator calculator2 = new Calculator(24.3, "-", 14.4);
		calculator2.performOperation();
		Double calc2Results = calculator2.getResults();
		System.out.println(calc2Results);
	}

}
