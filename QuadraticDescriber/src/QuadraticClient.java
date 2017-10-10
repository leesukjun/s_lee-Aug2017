/*James Lee
 * October 4, 2017
 */
import java.util.*;
public class QuadraticClient {
	public static void main(String args []) {
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			int a = userInput.nextInt();
			int b = userInput.nextInt();
			int c = userInput.nextInt();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Do you want to keep going? (Type \"1\" to end)");
			int answer = userInput.nextInt();
			if (answer==1) {
				done = true;
			}
		}
		System.out.println(("You are done"));
	}
}
