//James Lee
//October 4, 2017
//method that accepts the coefficient of quadratic formula and give description of it (ex. vertex, intercept)
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		if (a == 0) {//if a is 0, it is a linear equation.
			throw new IllegalArgumentException("The equation is not quadratic.");
		}
		double vertexX = -1 * b/(2 * a);
		double axisofsym = round2(vertexX);//axis of symmetry is essentially same as the x-coordinate of vertex
		double vertexY = a * vertexX * vertexX + b * vertexX + c;//Substituting x of the equation as x-coordinate of vertex 
		String vertex = "(" + round2(vertexX) + ", " + round2(vertexY) + ")";//rounds up the values of vertex
		double interceptY = c;//in the standard form, only c value remains when x is 0
		
		String root = "";
		double x = Quadratic.discriminant(a, b, c);
		if (x < 0) {//if discriminant is less than 0, it has no real root
			root = "None";
		}else {
			if (x == 0) {//if discriminant = 0, it has only one real root
				double dx =  round2((-b/(2*a)));
				root = "" + dx;
			}else {
				double firstroot =  round2(((-b + Quadratic.sqrt(x))/(2*a)));//using quadratic formula (+ version)
				double secondroot =  round2(((-b - Quadratic.sqrt(x))/(2*a)));//using quadratic formula (- version)
				if (firstroot < secondroot){
					root = firstroot + " and " + secondroot;
				}else {
					root = secondroot + " and " + firstroot;
				}
			}
		}
		String mouthdirection = "";//if the graph opens upward or downward
		if (a < 0){
			mouthdirection = "Down";
		} else {
			mouthdirection = "Up";
		}
		return "Description of the graph of:" + "\ny = " + a + " x^2 +" + b + " x +" + c + "\n\nOpens: " + mouthdirection + "\nAxis of Symmetry: " + axisofsym + "\nVertex: " + vertex + "\nx-intercept(s): " + root + "\ny-intercept: " + interceptY;
	}
	public static double discriminant(double A, double B, double C) {
		double discriminant = B * B - 4 * A * C;//formula of discriminant is B^2-4AC
		return discriminant;
	}
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
		return (squareRoot);
	}
	public static double absValue(double operand) {
		if (operand >= 0) {
			double absValue = operand;
			return absValue;
		} else {
			double absValue = (-1 * operand);//convert negative value to positive
			return absValue;
		}
	}
	public static double round2(double operand) {
		double one = absValue((int)(operand * 100));//absolute value of input*100 which includes two decimal place values
		double round2 = absValue(operand);//absolute value of the input 
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
}
