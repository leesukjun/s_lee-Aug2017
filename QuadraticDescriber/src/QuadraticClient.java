/*James Lee
 * October 4, 2017
 */
import java.util.*;
public class QuadraticClient {
	public static void main(String args []) {
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("type the coefficient of x^2");
			int a = userInput.nextInt();
			System.out.println("type the coefficient of x");
			int b = userInput.nextInt();
			System.out.println("type the value of constant");
			int c = userInput.nextInt();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String answer = userInput.next();
			String check = "quit";
			if (answer.toLowerCase().equals(check)) {
				done = true;
			}
		}
		System.out.println(("You are done"));
	}
}
