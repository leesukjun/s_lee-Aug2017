/*James Lee
 * October 4, 2017
 * Interact with user and, based on user's input, it gives the description of quadratic formula
 */
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		System.out.println("Welcome to the Quadratic Describer \nProvide values for coefficients a, b, and c");
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		boolean roundPrefer = true;
		System.out.println("\nDo you want us to round up your answer to hundredth decimal point?");
		System.out.println("If yes, print \"yes.\" if no, print \"no.\"");
		String rounding = userInput.next();
		if (rounding.toLowerCase().contains("no")) {//if the input contains the word "no" regardless of the caps
			roundPrefer = false;
		}
		while (!done) {
			System.out.print("\na: ");//takes the coefficient of x^2
			double a = userInput.nextDouble();
			System.out.print("b: ");//takes the coefficient of x
			double b = userInput.nextDouble();
			System.out.print("c: ");//takes the constant
			double c = userInput.nextDouble();
			if (roundPrefer) {
				System.out.println("\n" + Quadratic.quadrDescriber(a, b, c));
			} else {
				System.out.println("\n" + Quadratic.quadrDescriber1(a, b, c));
			}
			System.out.println("\nDo you want to keep going? (Type \"quit\" to end)");	
			
			userInput.nextLine();// Consume newline left-over
			String answer = userInput.nextLine();
			String answer2 = answer.replaceAll("\\s","");//remove spaces
			if (answer2.toLowerCase().contains("quit")) {//if the input contains the word "quit" regardless of the caps
				done = true;
			}
		}
		userInput.close();
		System.out.println("Thank you for using");
	}
}
