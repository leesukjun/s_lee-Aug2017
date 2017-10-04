/*James(Sukjun) Lee
 * September 6, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	//Square the input (integer)
	public static int square(int operand) {
		int squared = operand*operand;
		return squared;
	}
	//Cube the input (integer)
	public static int cube(int operand) {
		return operand*operand*operand;
	}
	//Average the two inputs (double) 
	public static double average(double operandA, double operandB) {
		double averagetwo = (operandA + operandB)/2;
		return averagetwo;
	}	
	//Average the three inputs (double) and returns a double
	public static double average(double operandA, double operandB, double operandC) {
		double average = (operandA + operandB + operandC)/3;
		return average;
	}
	//Converts radian (double) to degree (double)
	//pi is approximated to 3.14159
	public static double toDegrees(double radian) {
		double toDegree = radian * 180/3.14159;
		return toDegree;
	}
	//Converts degree (double) to radian (double)
	//pi is approximated to 3.14159
	public static double toRadians(double degree) {
		double toRadian = degree/180*3.14159;
		return toRadian;
	}
	//Calculates the value of discriminant with coefficients of quadratic equation (Ax^2+Bx+C)
	public static double discriminant(double A, double B, double C) {
		double discriminant = B * B - 4 * A * C;//formula of discriminant is B^2-4AC
		return discriminant;
	}
	//Converts a mixed number into an improper fraction (whole_numerator/denominator)
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int one = denominator * whole + numerator;//calculating the numerator of improper fraction form
		String toImproperFrac = one + "/" + denominator;
		return toImproperFrac;
	}
	//Converts improper fraction to mixed number 
	public static String toMixedNum(int numerator, int denominator) {
		int remainder = numerator % denominator;//remainder is the numerator of mixed number form
		int wholeNum = (numerator - remainder) / denominator;
		String toMixedNum = wholeNum + "_" + remainder + '/' + denominator;
		return toMixedNum;
	}
	//Converts a binomial multiplication of form (Ax+B)(Cx+D) into a quadratic form
	public static String foil(int A, int B, int C, int D, String x) {
		int one = A * C;//coefficient of x^2
		int two = A * D + C * B;//coefficient of x
		int three = B * D;//constant value
		String foil = one +x + "^2" + "+" + two +x + "+" + three;
		return foil;
	}
	//Determine whether or not one integer is evenly divisible by another
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) { //both can't be 0
			throw new IllegalArgumentException("numbers != 0");
		}
		if (dividend%divisor == 0) {//0 remainder means it completely divides
			boolean isDivisibleBy = true;
			return isDivisibleBy;
		} else {
			boolean isDivisibleBy = false;
			return isDivisibleBy;
		}
	}	
	//Returns the absolute value of the input (double)
	public static double absValue(double operand) {
		if (operand >= 0) {
			double absValue = operand;
			return absValue;
		} else {
			double absValue = (-1 * operand);//convert negative value to positive
			return absValue;
		}
	}
	//Return the larger number from the two inputs (double)
	public static double max(double operandA, double operandB) {
		if (operandA >= operandB) {
			double max = operandA;
			return max;
		} else {
			double max = operandB;
			return max;
		}
	}
	//Return the largest number from the three inputs (double)
	public static double max(double operandA, double operandB, double operandC) {
		if (operandA >= operandB && operandA >= operandC) { //If A is the greatest
			double max = operandA;
			return max;
		} else {
			if (operandB >= operandA && operandB>=operandC) { //If B is the greatest
				double max = operandB;
				return max;
			}else {
				double max = operandC; //If A and B aren't the greatest, C has to be
				return max;
			}
		}
	}
	//Returns the smaller of the values passed (integers)
	public static int min(int operandA, int operandB) {
		if (operandA >= operandB) {
			int min = operandB;
			return min;
		} else {
			int min = operandA;
			return min;
		}
	}
	//Rounds the input (double) correctly to 2 decimal places
	//Uses absolute value of the input for rounding process and then re-adds the sign at the end
	public static double round2(double operand) {
		double one = Calculate.absValue((int)(operand * 100));//absolute value of input*100 which includes two decimal place values
		double round2 = Calculate.absValue(operand);//absolute value of the input 
		if (100*round2-one >=0.5) {//if greater than 0.5, it means the 3rd decimal would be rounded up
			round2 = (int) (round2 * 100 + 1);
			round2 = round2/100;
		} else {
			round2 = (int) (round2 * 100);
			round2 = round2/100;
		}
		if (operand<=0){
			round2 = round2 * -1;//if the input was negative, convert the round2 to negative value
		}
		return round2;
	}	
	//Raises a value to a positive integer power
	public static double exponent(double base, int power) {
		int one = power;
		double x = 1;
		if (power < 0) {
			throw new IllegalArgumentException("The power of exponent must be > 0");
		} else {
			for (int i = 0; i < one; i++) {//multiplying the value as many times as the power
				x = x * base;
		}
		}
		return x;
	}
	//Calculates the value of the factorial
	public static int factorial(int operand) {
		if (operand < 0) {
			throw new IllegalArgumentException("number must be >= 0");
		}
		int product = 1;
		for (int i = 2; i <= operand; i++) {
			product = product * i; //multiplying with incremented value by 1 until the given value
		}	
		return product;
	}
	//Determines whether or not an integer is prime
	public static boolean isPrime(int value) {
		if(value < 1) {
			throw new IllegalArgumentException("exponent must be > 0");
		}
		for (int i=2; i<value ; i++) {
			if(Calculate.isDivisibleBy(value, i) == true) {//checking if the value is divisible by any value except 1
				return false;
			}
		}
		return true;
	}
	//Calculates the greatest common factor of two integers
	public static int gcf(int operandA, int operandB) {
		int gcf = 1;
		int smallNum = Calculate.min(operandA, operandB);
		for (int i = 2; i < smallNum; i++) { //gcf must be less the two integers or the minimum integer
			if (Calculate.isDivisibleBy(operandA, i) && Calculate.isDivisibleBy(operandB, i) == true) {
				gcf = i; //update the greatest common factor if two conditions above are satisfied
			}
		}
		return gcf;
	}
	//Approximates the square root of input (double), rounded to two decimal places
	//Uses Newton's method
	public static double sqrt(double square) {
		if (square < 0) {
			throw new IllegalArgumentException("number can't be negative.");
		}
		double guess;
		double squareRoot = square/2;
		do{
			guess = squareRoot;
		    squareRoot = (guess + (square/guess))/2;
		}while ((guess - squareRoot)!=0);
		return (Calculate.round2(squareRoot));
	}
	//Approximates the real roots, if any, from the coefficients of a quadratic equation in standard form
	public static String quadForm(int a, int b, int c) {
		double ax = a;
		double bx = b;
		double cx = c;
		double dx = 0;
		double x = Calculate.discriminant(ax, bx, cx);
		if (x < 0) {//if discriminant is less than 0, it has no real root
			return "no real roots";
		}else {
			if (x == 0) {//if discriminant = 0, it has only one real root
				dx = Calculate.round2((-b/(2*a)));
					return "root = " + dx;
			}else {
				double firstroot = Calculate.round2((-b + Calculate.sqrt(x))/(2*a));//using quadratic formula (+ version)
				double secondroot = Calculate.round2((-b - Calculate.sqrt(x))/(2*a));//using quadratic formula (- version)
				if (firstroot < secondroot){
					return "roots = " + firstroot + " and " + secondroot;
				}else {
					return "roots = " + secondroot + " and " + firstroot;
				}
			}
		}
	}
}
