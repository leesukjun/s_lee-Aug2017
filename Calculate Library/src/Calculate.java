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
	public static String toImproperFrac(int A, int B, int C) {
		int one = C * A + B;
		String toImproperFrac = one +'/' C;
		return toImproperFrac;
	}
	//Improper to mixed number
	public static String toMixedNum(int A, int B) {
		String toMixedNum = (A-(A%B))/B + '_' + A%B + '/' +B;
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
	
}
