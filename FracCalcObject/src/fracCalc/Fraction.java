package fracCalc;

public class Fraction {

	private int numerator = 0;
	private int denominator = 1;
	private int whole = 0;
	
	public Fraction(String fractionStr) {
		parsingMethod(fractionStr);
	}
	public Fraction(int whole, int numerator, int denominator) {
		this.whole = whole;
		this.numerator = numerator;
		this.denominator = denominator;
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
	public Fraction calculation(Fraction Second, String operator) {
		this.prepareCalc();
		Second.prepareCalc();
		Fraction answer;
		if (operator.contains("+")) {
			answer = addFrac(Second);
		} else {
			if (operator.contains("-")) {
				answer = subtractFrac(Second);
			} else {
				if (operator.contains("/")) {
					answer = divideFrac(Second);
				} else {
					if (operator.contains("*")) {
						answer = multiplyFrac(Second);
					} else {
						throw new IllegalArgumentException ("this is not a correct operator");
					}
				}
			}
		}
		answer.simplyFrac();
		return answer;
	}
	private Fraction addFrac(Fraction Second) {
		int num = this.numerator * Second.denominator + Second.numerator*this.denominator;
		int den = this.denominator * Second.denominator;
		Fraction answer = new Fraction(0, num, den);
		return answer;
	}
	private Fraction subtractFrac(Fraction Second) {
		int num = this.numerator * Second.denominator - Second.numerator*this.denominator;
		int den = this.denominator * Second.denominator;
		Fraction answer = new Fraction(0, num, den);
		return answer;
	}
	private Fraction multiplyFrac(Fraction Second) {
		int num = this.numerator * Second.numerator;
		int den = this.denominator * Second.denominator;
		Fraction answer = new Fraction(0, num, den);
		return answer;
	}
	private Fraction divideFrac(Fraction Second) {
		int num = this.numerator * Second.denominator;
		int den = this.denominator * Second.numerator;
		Fraction answer = new Fraction(0, num, den);
		return answer;
	}
	private void prepareCalc() {
		if (this.whole>=0) {
			this.numerator = whole * denominator + numerator;
		} else {
			this.numerator = whole * denominator - numerator;
		}
		this.whole = 0;
	}
	private void simplyFrac() {
		if (denominator<0) {
			denominator *= -1;
			numerator *= -1;
		}
		whole = numerator/denominator;
		numerator = numerator%denominator;
		if (numerator<0 && whole!=0) {
			numerator *= -1;
		}
		int gcf = gcf(numerator, denominator);
		numerator /= gcf;
		denominator /= gcf;
    }
	public String toString() {
		if (this.numerator==0) {
			return ""+ whole;
		} 
		if (this.whole==0) {
			return "" + numerator + "/" + denominator;
		}
		return "" + whole +"_" + numerator + "/" + denominator;
	}
    public static int gcf(int numerator, int denominator) {
    	int gcf = 1;
		int count;
    	if (numerator == denominator || numerator > denominator ) {
    		count = denominator;
    	} else {
    		count = numerator;
    	}
    	if (count<0) {
    		count *= -1;
    	}
		for(int i = 2; i <= count; i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				gcf = i;
			}
		}
		return gcf;
    }
}
