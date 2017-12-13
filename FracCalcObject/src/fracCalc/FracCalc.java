package fracCalc;

import java.util.Scanner;

public class FracCalc {

	   public static void main(String[] args) {
	        // Read the input from the user and call produceAnswer with an equation
	    	Scanner userInput = new Scanner(System.in);
	    	String input = " ";
	    	while (!input.equals("quit")) {
	        	System.out.println("Enter fraction string.");
	    		input = userInput.nextLine();
	    		if (!input.toLowerCase().contains("quit")) {
	    				System.out.println(produceAnswer(input));
	    			}
	    		}
	    	}
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
		public static String produceAnswer(String input) {
			String[] parsedInput = input.split(" ");
			if (parsedInput.length % 2 == 0 || parsedInput.length == 1) {
				return "ERROR: Invalid equation. Please try again.";
			}
			String resultString = "";
			for (int i = 2; i < parsedInput.length; i += 2) {
				Fraction operand1 = new Fraction(parsedInput[0]);
				Fraction operand2 = new Fraction(parsedInput[i]);
				String operator = parsedInput[i-1];
				resultString = operand2.toString();
			}
			return resultString;
		}
	}