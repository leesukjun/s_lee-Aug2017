// James Lee 11/13/2017
// Takes a mathematical expression 
//(involving fractions and mixed numbers)
// that the user inputs, and calculates and returns the result. 
package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	String input = " ";
    	while (!input.equals("quit")) {
        	System.out.println("Enter fraction string.");
    		input = userInput.nextLine();
    		if (!input.toLowerCase().contains("quit")) {
    			System.out.println(produceAnswerMK2(input));
    		}
    	}
    }
    public static String produceAnswerMK1 (String input) {
    	int how1Many = 0;
    	String vol1 = "";
    	String vol2 = "";
    	for (int i = 0; i < input.length(); i++) {
    		if (input.substring(i, i+1).equals("+")) {
    			how1Many++;
    		}
    	}
    	if (how1Many >= 2) {
    		vol1 = input.substring(0, ordinalIndexOf(input," ",3));
    		vol2 = input.substring(ordinalIndexOf(input, " ",3));
    	} else {
    		vol1 = input;
    	}
    	String firstAnswer = produceAnswer(vol1);
    	String newString = firstAnswer + vol2;
    	return newString;
	}	
    public static String produceAnswerMK2 (String input) {
    	String answer = input;
    	boolean done = false;
    	while (!done) {
    		if (answer.contains(" ")) {
    			answer = produceAnswerMK1(answer);
    		} else {
    			done = true;
    		}
    	}
    	return answer;
    }
    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
    // Calculate and return the answer to the expression that the user inputs.
    public static String produceAnswer(String input) {
    	
    	// Parse input into firstOperand, operator, and secondOperand.
        String firstOperand = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")+ 1), (input.indexOf(" ")+ 2)); 
        String secondOperand = input.substring(input.lastIndexOf(" ") + 1);
        
        // Create integer arrays for the parts of each operand.
        int firstOperandArray [] = parseOperand(firstOperand);
        int secondOperandArray [] = parseOperand(secondOperand);
        if (firstOperandArray [2] == 0 || secondOperandArray [2] == 0) {
        	throw new IllegalArgumentException("Cannot divide by zero.");
        }

        // Create a third integer array to hold the values after the operation method is called.
        int [] combinedOperandArray= new int [3];
        
        // Test to find out what operator is being used, call different operation methods depending on operator
        // Set result to the value returned from the operation method
        if (operator.equals("+")) {
        	 combinedOperandArray = addFrac(firstOperandArray, secondOperandArray);
        }
        else {
        	if (operator.equals("-")) {
        		combinedOperandArray = subtractFrac(firstOperandArray, secondOperandArray);
        	}
        	else {
        		if (operator.equals("*")) {
        			combinedOperandArray = multiplyFrac(firstOperandArray, secondOperandArray);
        		}
        		else {
        			if (operator.equals("/")) {//obviously will be division.
        				combinedOperandArray = divideFrac( firstOperandArray, secondOperandArray);
        			}
        			else {
        				throw new IllegalArgumentException("Input is in an invalid format.");
        			}
        		}      		
        	}
        }
        // If the the result is not a whole number, reduce it.
        if (combinedOperandArray[1] != 0 && combinedOperandArray[2] != 0) {
        	reduceFrac(combinedOperandArray);	
        }
        
        if (combinedOperandArray[0] == 0) {
        	if (combinedOperandArray[1] == 0 || combinedOperandArray[2] == 0) {
        		// Whole number = 0 and either numerator or denominator = 0.
        		return "0";
        	}
        	else {
            	// Whole number = 0.
        		return "" + combinedOperandArray[1] + "/" + combinedOperandArray[2];
        	}
        }
        else {
        	if (combinedOperandArray[1] == 0 || combinedOperandArray[2] == 0) {
        		// Either numerator or denominator = 0.
        		return "" + combinedOperandArray[0];
        	}
        	else { 
        		// No part of the answer = 0.
        		return ""  + combinedOperandArray[0] + "_" + combinedOperandArray[1] + "/" + combinedOperandArray[2];
        	}
        }
    }
    // Parse an operand into three parts: whole, numerator, and denominator.
    public static int [] parseOperand(String operand) {
        // Set default values for whole, numerator and denominator.
    	int whole = 0;
        int numerator = 0;
        int denominator = 1;
        
        // Test if there is a whole number.
        if (operand.indexOf("_") > 0) {
        	whole = Integer.valueOf(operand.substring(0, operand.indexOf("_")));
        }
        
        	// Test if there is a fraction.
        	if (operand.indexOf("/") < 0) {
        		whole = Integer.valueOf(operand);
        	}
        	else {
        	numerator = Integer.valueOf(operand.substring(operand.indexOf("_") + 1, operand.indexOf("/")));
        	denominator = Integer.valueOf(operand.substring(operand.indexOf("/") + 1));
        	}

        // Create and return an array with the whole, numerator and denominator of the operand.
        int operandArray [] = new int [] { whole, numerator, denominator};
        return operandArray;
    }
    // Convert a mixed number into an improper fraction.
    // modified from Calc. Library.
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
    	if (whole >= 0){
    	numerator = ((whole * denominator) + numerator);
    	}
    	else {
    		whole *= -1;
    		numerator = ((whole * denominator) + numerator);
    		numerator *= -1;
    	}
    	int returnArray[] = new int [] {numerator, denominator};
    	return returnArray;   	
    }
    // Add two fractions or mixed numbers.
    public static int [] addFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	// Test to see if the denominators of the fractions are equivalent.
    	if (firstOperandArray[2] != secondOperandArray[2]){
    		firstOperandArray[1] = firstOperandArray[1] * secondOperandArray[2];
    		secondOperandArray[1] *= firstOperandArray[2];
    		firstOperandArray[2] = firstOperandArray[2] * secondOperandArray[2];
    	}
    	
    	// If a whole number is negative, make sure the numerator of the fraction is positive.
    	if (firstOperandArray[0] < 0){
    		firstOperandArray[1] *= -1;
    	}
    	if (secondOperandArray[0] < 0){
    		secondOperandArray[1] *= -1;
    	}
    	
    	// Add the numerators of the fractions.
    	firstOperandArray[1] += secondOperandArray[1];
    	if (firstOperandArray[1] < 0){
    		firstOperandArray[1] *= -1;
    	}
    	// Add the whole numbers.
    	firstOperandArray[0] += secondOperandArray[0];
    	return firstOperandArray;
    }
    // Subtract two fractions or mixed numbers.
    public static int [] subtractFrac(int [] firstOperandArray, int [] secondOperandArray) {
   
    	// Multiply both numerators by the denominator of the other operand.
    	firstOperandArray[1] *= secondOperandArray[2];
    	secondOperandArray[1] *= firstOperandArray[2];
    	
    	// Multiply denominators to get a common denominator
    	firstOperandArray[2] *= secondOperandArray[2];
    	
    	// If a whole number is negative, make sure the numerator of the fraction is positive.
    	if (firstOperandArray[0] < 0) {
    		firstOperandArray[1] *= -1;
    	}
    	if (secondOperandArray[0] < 0) {
    		secondOperandArray[1] *= -1;
    	}
    	// Subtract the numerators.
    	firstOperandArray[1] -= secondOperandArray[1];
    	if (firstOperandArray[1] < 0 && firstOperandArray[0] < 0){
    		firstOperandArray[1] *= -1;
    	}
    	// Subtract the whole numbers.
    	firstOperandArray[0] -= secondOperandArray[0];
    	if (firstOperandArray[0] == -1 && (firstOperandArray[1] > 0 && firstOperandArray[2] > 0)) { 
    		if (firstOperandArray[0] < secondOperandArray[0]) {
    		firstOperandArray[1] = (firstOperandArray[0]*firstOperandArray[2]) + firstOperandArray[1];
    		}
    		else {
    			firstOperandArray[1] = (firstOperandArray[0]*firstOperandArray[2]) - firstOperandArray[1];
    		}
    		firstOperandArray[0] = 0;
    	}
    	return firstOperandArray;
    }
    // Multiply two fractions or mixed numbers.
    public static int [] multiplyFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	// Test if each operand is a mixed number, convert to an improper fraction if it is.
    	// Create an integer array to hold the new values and to return.
    	int [] returnArray = new int [3];
    	int [] operand1 = new int [3];
    	int [] operand2 = new int [3];
    	
    	if(firstOperandArray[0] != 0 && secondOperandArray[0] != 0) {
    		// Both operands are mixed numbers.
    		operand1 = toImproperFrac(firstOperandArray[0], firstOperandArray[1], firstOperandArray[2]);
        	operand2 = toImproperFrac(secondOperandArray[0], secondOperandArray[1], secondOperandArray[2]);
        	returnArray[1] = operand1[0] * operand2[0];
        	returnArray[2] = operand1[1] * operand2[1];
    	}
    	else {
    		if(firstOperandArray[0] != 0 && secondOperandArray[0] == 0) {
    			// The first operand is a mixed number.
        		operand1 = toImproperFrac(firstOperandArray[0], firstOperandArray[1], firstOperandArray[2]);
        		returnArray[1] = operand1[0] * secondOperandArray[1];
        		returnArray[2] = operand1[1] * secondOperandArray[2];
        	}
    		else{
    			if(secondOperandArray[0] != 0 && firstOperandArray[0] == 0) {
    				// The second operand is a mixed number.
            		operand2 = toImproperFrac(secondOperandArray[0], secondOperandArray[1], secondOperandArray[2]);
            		returnArray[1] = operand2[0] * firstOperandArray[1];
            		returnArray[2] = operand2[1] * firstOperandArray[2];
            	}
    			else{
    				// Neither operand is a mixed number.
    				returnArray[1] = firstOperandArray[1] * secondOperandArray[1];
    	    		returnArray[2] = firstOperandArray[2] * secondOperandArray[2];
    			}
    		}
    	}
    	return returnArray;
    }
    // Divide two fractions or mixed numbers.
    public static int [] divideFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	// Test if each operand is a mixed number, convert to an improper fraction if it is.
    	// Create an integer array to hold the new values and to return.
    	int [] returnArray = new int [3];
    	int [] operand1 = new int [3];
    	int [] operand2 = new int [3];
    	if(firstOperandArray[0] != 0 && secondOperandArray[0] != 0) {
    		// Both operands are mixed numbers.
    		operand1 = toImproperFrac(firstOperandArray[0], firstOperandArray[1], firstOperandArray[2]);
        	operand2 = toImproperFrac(secondOperandArray[0], secondOperandArray[1], secondOperandArray[2]);
        	returnArray[1] = operand1[0] * operand2[1];
        	returnArray[2] = operand1[1] * operand2[0];
    	}
    	else {
    		if(firstOperandArray[0] != 0 && secondOperandArray[0] == 0) {
    			// The first operand is a mixed number.
        		operand1 = toImproperFrac(firstOperandArray[0], firstOperandArray[1], firstOperandArray[2]);
        		returnArray[1] = operand1[0] * secondOperandArray[2];
        		returnArray[2] = operand1[1] * secondOperandArray[1];
        	}
    			else{
    				// The second operand is a mixed number.
    				if(secondOperandArray[0] != 0 && firstOperandArray[0] == 0) {
    					operand2 = toImproperFrac(secondOperandArray[0], secondOperandArray[1], secondOperandArray[2]);
    					returnArray[1] = operand2[0] * firstOperandArray[2];
    					returnArray[2] = operand2[1] * firstOperandArray[1];
    				}
    					else {
    						// Neither operand is a mixed number.
    						returnArray[1] = firstOperandArray[1] * secondOperandArray[2];
    						returnArray[2] = firstOperandArray[2] * secondOperandArray[1];
    					}
    			}
    	}
    	return returnArray;
    }
    // Reduce an improper fraction or mixed number to its simplest form.
    public static int [] reduceFrac(int [] combinedOperandArray) {
    	int gcf;
    	// Test if the combined operand is a mixed number.
    	// If it is not, convert it to one.
    	if (combinedOperandArray[0] == 0) {
    		combinedOperandArray[0] = combinedOperandArray[1]/combinedOperandArray[2];
    		combinedOperandArray[1] = combinedOperandArray[1]%combinedOperandArray[2];
    	}
    	
    	// Test if the numerator of the fraction portion is divisible by the denominator.
    	// If so, divide and add the result to the whole number.
    	if(combinedOperandArray[1]%combinedOperandArray[2] == 0) {
    		combinedOperandArray[0] += combinedOperandArray[1]/combinedOperandArray[2];
    		combinedOperandArray[1] = 0;
    		combinedOperandArray[2] = 0;
    	}
    		// If the numerator is not divisible by the denominator,
    		// find the gcf of the two numbers.
    		else {
    			gcf = gcf(combinedOperandArray[1], combinedOperandArray[2]);
    				// Test if the gcf is positive.
    				if (combinedOperandArray[0] > 0) {
    				combinedOperandArray[0] += combinedOperandArray[1]/combinedOperandArray[2];
    				combinedOperandArray[1] = combinedOperandArray[1]%combinedOperandArray[2];
    				}
    				else {
    					combinedOperandArray[0] -= combinedOperandArray[1]/combinedOperandArray[2];
        				combinedOperandArray[1] = combinedOperandArray[1]%combinedOperandArray[2];
    				}
    					// Divide the numerator and denominator by the gcf.
    					combinedOperandArray[1] /= gcf;
    					combinedOperandArray[2] /= gcf;
    		}
    	// Test if either the numerator or denominator is negative.
    	if (combinedOperandArray[1] < 0 || combinedOperandArray[2] < 0) {
    		// If the numerator is positve, there is no whole number,
    		// and the denominator is negative, make the denominator
    		// positive and the numerator negative.
    		if(combinedOperandArray[0] == 0 && combinedOperandArray[1] > 0) {
				combinedOperandArray[2] *= -1;
				combinedOperandArray[1] *= -1;
    		}
    		else{
    			// If there is no whole number, and both the numerator
    			// and denominator are negative, make both positive.
    			if (combinedOperandArray[0] < 0 || ((combinedOperandArray[1] < 0 && combinedOperandArray[2] < 0))) {
    				if (combinedOperandArray[1] < 0 ) {
    					combinedOperandArray[1] *= -1;
    				}
    				if (combinedOperandArray[2] < 0 ) {
    				combinedOperandArray[2] *= -1;
    				}
    			}
    		}
    	}
    	return combinedOperandArray;
    }
    // Find the gcf of two numbers (numerator and denominator of the fractional part of the mixed number).
    // from calc. library.
    public static int gcf(int numerator, int denominator) {
    	// Set the initial value of gcf to 1 (the lowest possible gcf.
    	int gcf = 1;
    	
    	// Declare a variable for the amount of times the loop will run.
    	// Set it to whichever number is larger.
		int count;
    	if (numerator == denominator || numerator > denominator ) {
    		count = numerator;
    	}
    	else {
    		count = denominator;
    	}
		for(int i = 1; i < Math.abs(count); i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				gcf = i;
			}
		}
		return gcf;
    }
}