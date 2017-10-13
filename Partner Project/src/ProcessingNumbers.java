/*James Lee
 * October 4, 2017
 */
import java.util.*;
public class ProcessingNumbers {
	public static void main(String args []) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many terms are you going to enter?");
		int terms = userInput.nextInt();
		System.out.println("Enter your " + terms + " integers");
		int max = userInput.nextInt();
		int min = max;
		int inputNumber;
		int evenSum = 0;
		int maxEven = 11;//any odd number that correspond to if statement in line 43
		
		boolean firstEven = true;
		if(min % 2 == 0) {
			evenSum = min;
			maxEven = min;
			firstEven = false;
		}
		for(int i = 1; i < terms; i++) {
			inputNumber = userInput.nextInt();
			if (inputNumber % 2 == 0) {
				if (firstEven == true) {
					maxEven = inputNumber;
					evenSum = inputNumber;
					firstEven = false;
				}
				else {
					if (inputNumber > maxEven) {
						maxEven = inputNumber;
					}
				evenSum += inputNumber;
				}
			}
			if (inputNumber > max) {
				max = inputNumber;
			}
			if (inputNumber < min) {
				min = inputNumber;
			}
		}		
	System.out.println("min: " + min + " max: " + max);
	if (maxEven != 11 ) {
		System.out.println("Sum of even numbers: " + evenSum + " Largest even number: " + maxEven);
	} else {//if it stays as 11, it means there is no even number entered. If so, there is no maxEven
		System.out.println("Sum of even numbers: " + evenSum + " Largest even number: Does not exist"
				);
	}
	}
}