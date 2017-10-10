/*James Lee
 * October 4, 2017
 */
import java.util.*;
public class QuadraticClient {
	public static void main(String args []) {
		boolean done = false;
		while (!done) {
			Scanner userInput = new Scanner(System.in);
			int a = userInput.nextInt();
			int b = userInput.nextInt();
			int c = userInput.nextInt();
			System.out.print (Quadratic.quadrDescriber(a, b, c));
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			boolean answer = userInput.next.int();
			if toUpperCase(answer) == QUIT {
				done = true;
			}
		}
		userInput.close();
	}
}
