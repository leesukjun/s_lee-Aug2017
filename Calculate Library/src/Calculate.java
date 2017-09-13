/*James Lee
 * September 6, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	//square the input
	public static int square(int operand) {
		int squared = operand*operand;
		return squared;
	}
	//Cube the input
	public static int cube(int operand) {
		return operand*operand*operand;
	}
	//accepting two doubles and returns a double
	public static double average(double operandA, double operandB) {
		double averagetwo = (operandA * operandB);
		return averagetwo/2;
	}	
	//accepting three doubles and returns a double
	public static double average(double operandA, double operandB, double operandC) {
		double average = (operandA * operandB * operandC);
		return average/3;
	}
	//converting angle to radian
	public static double toDegrees(double operand) {
		double toDegree = operand * 180/3.141592;
		return toDegree;
	}
	//convert an angle measure given in degrees
	public static double toRadians(double operand) {
		double toRadian = operand/180*3.141592;
		return toRadian;
	}
	//provides the coefficients of a quadratic question 
	public static double discriminant(double A, double B, double C) {
		double discriminant = B * B - 4 * A * C;
		return discriminant;
	}
	//converts mixed number into an improper fraction A_b/c
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int one = denominator * whole + numerator;
		String toImproperFrac = one + "/" + denominator;
		return toImproperFrac;
	}
	//Improper to mixed number (A/B)
	public static String toMixedNum(int A, int B) {
		int one = A % B;
		int two = A - one;
		int three = two / B;
		String toMixedNum = three + "_" + one + '/' + B;
		return toMixedNum;
	}
	//converts a binomial multiplication of form (Ax+B)(Cx+D) into a quadratic form)
	public static String foil(int A, int B, int C, int D, String x) {
		int one = A * C;
		int two = A * D + C * B;
		int three = B * D;
		String foil = one +x + "^2" + '+' + two +x + '+' + three;
		return foil;
	}
	//Determine whether or not one integer is evenly divisible by another
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if (numerator%denominator == 0) {
			boolean isDivisibleBy = true;
			return isDivisibleBy;
		} else {
			boolean isDivisibleBy = false;
			return isDivisibleBy;
		}
	}	
	//absValue returns the absolute value of the number passed
	public static double absValue(double A) {
		if (A <= 0) {
			double absValue = A;
			return absValue;
		} else {
			double absValue = (-1 * A);
			return absValue;
		}
			
	}
	//return the larger the values passed
	public static double max(double A, double B) {
		if (A >= B) {
			double max = A;
			return max;
		} else {
			double max = B;
			return max;
		}
	}
	//Accepts three doubles and returns a double
	public static double max(double A, double B, double C) {
		if (A >= B) {
		}
		if (A >= C) {
			double max = A;
			return max;
		} else if (B >= C) {
			double max = B;
			return max;
		} else {
			double max = C;
			return max;
		}
	}
	//min returns the smaller of the values passed. The method accepts two integers and returns an int.
	public static int min(int A, int B) {
		if (A >= B) {
			int min = B;
			return min;
		} else {
			int min = A;
			return min;
		}
	}
	//round2 rounds a double correctly to 2 decimal places and returns a double
	public static double round2(double A) {
		double one = Math.round(A * 100);
		double round2 = one / 100;
		return round2;
		}	
	//exponent accepts a double and an integer and returns a double
	public static double exponent(double A, int B) {
		int one = B;
		double x = 1;
			for (int i = 0; i < one; i++) {
				x = x * A;
		}
		return x;
	}
}