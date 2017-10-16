import java.util.Scanner;

/**
 * This is my first program
 * @author APCS2
 *8.21.2017
 */
public class Hello_world {

	public static void main(String[] args) {
		System.out.println("Welcome to the Quadratic Describer \nProvide values for coefficients a, b, and c");
		Scanner userInput = new Scanner(System.in);
		double a = userInput.nextDouble();
		userInput.nextLine();
		String answer = userInput.nextLine();
		String answer2 = answer.replaceAll("\\s","");
		System.out.println (answer2 + a);
	}
}
