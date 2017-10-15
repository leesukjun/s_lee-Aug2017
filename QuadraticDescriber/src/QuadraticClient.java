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
		while (!done) {
			System.out.print("\na: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println("\n" + Quadratic.quadrDescriber(a, b, c));
			System.out.println("\nDo you want to keep going? (Type \"quit\" to end)");
			String answer = userInput.next();
			String check = "quit";
			if (answer.toLowerCase().contains(check)) {
				done = true;
			}
		}
		userInput.close();
	}
}
