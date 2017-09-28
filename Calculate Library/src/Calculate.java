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
		double averagetwo = (operandA + operandB);//Add two inputs
		return averagetwo/2;//divide the sum by two
	}	
	//accepting three doubles and returns a double
	public static double average(double operandA, double operandB, double operandC) {
		double average = (operandA * operandB * operandC);//Add three inputs
		return average/3;//divide the sum by three
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
		double discriminant = B * B - 4 * A * C;//formula of discriminant=B^2-4AC
		return discriminant;
	}
	//converts mixed number into an improper fraction A_b/c
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int one = denominator * whole + numerator;//calculating the numerator when the fraction is converted to improper
		String toImproperFrac = one + "/" + denominator;
		return toImproperFrac;
	}
	//Improper to mixed number (A/B)
	public static String toMixedNum(int A, int B) {
		int one = A % B;//remainder = numerator for the mixed number
		int two = A - one;
		int three = two / B;//the whole number in the mixed number
		String toMixedNum = three + "_" + one + '/' + B;
		return toMixedNum;
	}
	//converts a binomial multiplication of form (Ax+B)(Cx+D) into a quadratic form)
	public static String foil(int A, int B, int C, int D, String x) {
		int one = A * C;//coefficient of x^2
		int two = A * D + C * B;//coefficient of x
		int three = B * D;//constant value
		String foil = one +x + "^2" + '+' + two +x + '+' + three;
		return foil;
	}
	//Determine whether or not one integer is evenly divisible by another
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if (numerator == 0 || denominator == 0) { //both can't be 0
			throw new IllegalArgumentException("numbers != 0");
		}
		if (numerator%denominator == 0) {//0 remainder means it completely divides
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
			double absValue = (-1 * A);//convert negative value to positive
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
		if (A >= B && A >= C) { //If A is the greatest
			double max = A;
			return max;
		} else {
			if (B >= A && B>=C) { //If B is the greatest
				double max = B;
				return max;
			}else {
				double max = C; //If A and B are not the greatest, C has to be
				return max;
			}
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
		double one = (int) (A * 100); //X100 and casting to int would give 100 times of the value with 2 decimals
		double round2 = A;
		If (A>=0){
			if (100*A-one >=0.5) {//if greater than 0.5, it means the 3rd decimal would be rounded up
				round2 = (int) (A * 100 + 1);
				round2 = round2/100;
			} else {
				round2 = (int) (A * 100);
				round2 = round2/100;
		} else {
			if (100*A-one <=-0.5) {//if less than -0.5, it means the 3rd decimal would be rounded
				round2 = (int) (A * 100 - 1);
				round2 = round2/100;
			} else {
				round2 = (int) (A * 100);
				round2 = round2/100;
			}
		}
		return round2;
	}	
	//exponent accepts a double and an integer and returns a double
	public static double exponent(double A, int B) {
		int one = B;
		double x = 1;
		if (B < 0) {
			throw new IllegalArgumentException("exponent must be > 0");
		} else {
			for (int i = 0; i < one; i++) {//multiplying the value as many times as the power
				x = x * A;
		}
		}
		return x;
	}
	//accepts an integer and return an integer
	public static int factorial(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("number must be >= 0");
		}
		int product = 1;
		for (int i = 2; i <= x; i++) {
			product = product * i; //multiplying with incremented value by 1 until the given value
		}	
		return product;
	}
	//isPrime determines whether or not an integer is prime
	public static boolean isPrime(int x) {
		if(x < 1) {
			throw new IllegalArgumentException("exponent must be > 0");
		}
		for (int i=2; i<x ; i++) {
			if(Calculate.isDivisibleBy(x, i) == true) {//checking if the value is divisible by any value except 1
				return false;
			}
		}
		return true;
	}
	//gcf finds the greatest common factor of two integers
	public static int gcf(int num1, int num2) {
		int gcf = 1;
		int smallNum = Calculate.min(num1, num2);
		for (int i = 2; i < smallNum; i++) {
			if (Calculate.isDivisibleBy(num1, i) && Calculate.isDivisibleBy(num2, i) == true) {
				gcf = i; //update the greatest common factor if two conditions above are satisfied
			}
		}
		return gcf;
	}
	//sqrt returns an approximation of the square root of the value passed, rounded to two decimal places
	public static double sqrt(double square) {
		if (square < 0) {
			throw new IllegalArgumentException("number can't be negative.");
		}
		double squareRoot = 1;//arbitrary starting value
		while (squareRoot * squareRoot > (square + .1) || squareRoot * squareRoot < (square - .1)) {
			while (squareRoot * squareRoot < square) {
				squareRoot = squareRoot + .001;//add 0.01 when the squareRoot^2 is less than the input
			}
			while (squareRoot * squareRoot > square) {
				squareRoot = squareRoot - .001;//subtract 0.01 when the squareRoot^2 is more than the input
			}
		}
		return (Calculate.round2(squareRoot));
	}
	//quadForm uses the coefficients of a quadratic equation in standard form
	//and uses quadratic formula to approximate the real roots, if any
	public static String quadForm(int a, int b, int c) {
		double ax = a;
		double bx = b;
		double cx = c;
		double dx = 0;
		double x = Calculate.discriminant(ax, bx, cx);
		if (x < 0) {//if discriminant is less than 0, it has no real root
			return "no real roots";
		}else {
			if (x == 0) {
				dx = Calculate.round2((-b/(2*a)));
					return "" + dx;
			}else {
				double firstroot = Calculate.round2((-b + Calculate.sqrt(x))/(2*a));//using quadratic formula
				double secondroot = Calculate.round2((-b - Calculate.sqrt(x))/(2*a));//using quadratic formula
				if (firstroot < secondroot){
					return "roots = " + firstroot + " and " + secondroot;
				}else {
					return "roots = " + secondroot + " and " + firstroot;
				}
			}
		}
	}
}
