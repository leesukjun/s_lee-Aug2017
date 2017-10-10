//James Lee
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		double vertexX = -1 * b/(2 * a);
		double axisofsym = vertexX;
		double vertexY = a * vertexX * vertexX + b * vertexX + c;
		String vertex = "<" + vertexX + "," + vertexY + ">";
		double interceptY = c;
		
		String root = "";
		double x = Quadratic.discriminant(a, b, c);
		if (x < 0) {//if discriminant is less than 0, it has no real root
			root = "no real roots";
		}else {
			if (x == 0) {//if discriminant = 0, it has only one real root
				double dx = (-b/(2*a));
				root = "" + dx;
			}else {
				double firstroot = ((-b + Quadratic.sqrt(x))/(2*a));//using quadratic formula (+ version)
				double secondroot = ((-b - Quadratic.sqrt(x))/(2*a));//using quadratic formula (- version)
				if (firstroot < secondroot){
					root = firstroot + " and " + secondroot;
				}else {
					root = secondroot + " and " + firstroot;
				}
			}
		}
		String mouthdirection = "";
		if (a < 0){
			mouthdirection = "open downward";
		} else {
			mouthdirection = "open upward";
		}
		return "Description of the graph of:" + "\ny = " + a + "x^2 +" + b + "x +" + c + "\n\ndirection = " + mouthdirection + "\nAxis of Symmetry: " + axisofsym + "\nVertex: " + vertex + "\nx-intercept= " + root + "\ny-intercept: " + interceptY;
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
}
