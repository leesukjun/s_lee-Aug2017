package fracCalc;

public class Fraction {

	private int numerator = 0;
	private int denominator = 1;
	private int whole = 0;
	
	public Fraction(String fractionStr) {
		parsingMethod(fractionStr);
	}
	private void parsingMethod(String operand) {
		if (operand.contains("/") && operand.contains("_")) {
			numerator = (Integer.parseInt(operand.split("_")[1].split("/")[0]));
			denominator = (Integer.parseInt(operand.split("/")[1]));
			whole = (Integer.parseInt(operand.split("_")[0]));
		} else if (operand.contains("/") && !(operand.contains("_"))) {
			numerator = (Integer.parseInt(operand.split("/")[0]));
			denominator = (Integer.parseInt(operand.split("/")[1]));
		} else {
			whole = Integer.parseInt(operand);
		}
	}
	public String toString() {
		return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
	}
}
