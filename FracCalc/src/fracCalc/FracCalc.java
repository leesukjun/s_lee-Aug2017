// James Lee 11/13-16/2017
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
    			if (checkCondition(input).equals("work")) {
    				System.out.println(produceAnswer(input));
    			} else {
    				System.out.println(checkCondition(input));
    			}
    		}
    	}
    }
    public static String checkCondition (String input) {
        String firstOperand = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")), (input.indexOf(" ")+ 3)); 
        String secondOperand = input.substring(input.lastIndexOf(" ") + 1);
        String result = "work";
        int firstOperandArray [] = parseOperand(firstOperand);
        int secondOperandArray [] = parseOperand(secondOperand);
        if (firstOperandArray [2] != 0 && secondOperandArray [2] != 0) {
        	if (operator.equals(" + ")) {
        	} else {
        		if (operator.equals(" - ")) {
        		} else {
        			if (operator.equals(" * ")) {
        			} else {
        				if (operator.equals(" / ")) {
        					if (secondOperandArray[1]==0) {
        						result = "Error: Cannot divide by zero.";
        					}
        				} else {
        					result ="Error: Input is in an invalid format.";
        				}
        			}      		
        		}
        	}
        } else {
        	return "Error: Cannot divide by zero.";
        }
        return result;
    }
    public static String produceAnswer(String input) {//main producer
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
    //method that detects the index of the nth occurring character 
    public static int ordinalIndexOf(String str, String substr, int n) {
        int position = str.indexOf(substr);
        while (--n > 0 && position != -1)
        	position = str.indexOf(substr, position + 1);
        return position;
    }
    public static String produceAnswerMK1 (String input) {
    	String answer = input;
    	int howMany = 0;
    	String vol1 = "";
    	String vol2 = "";
    	for (int i = 0; i < answer.length()-1; i++) {
    		if (answer.substring(i, i+2).equals("+ ")) {
    			howMany++;
    		} 
    		if (answer.substring(i, i+2).equals("- ")) {
    			howMany++;
    		} 
    		if (answer.substring(i, i+2).equals("* ")) {
    			howMany++;
    		} 
    		if (answer.substring(i, i+2).equals("/ ")) {
    			howMany++;
    		} 
    	}
    	if (howMany >= 2) {
    		vol1 = answer.substring(0, ordinalIndexOf(answer," ",3));
    		vol2 = answer.substring(ordinalIndexOf(answer, " ",3));
    	} else {
    		vol1 = input;
    	}
    	String firstAnswer = produceAnswerMK2(vol1);
    	String newString = firstAnswer + vol2;
    	return newString;
	}	
    // Calculate and return the answer to the expression that the user inputs.
    public static String produceAnswerMK2(String input) {
    	
    	// Parse input into firstOperand, operator, and secondOperand.
        String firstOperand = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")), (input.indexOf(" ")+ 3)); 
        String secondOperand = input.substring(input.lastIndexOf(" ") + 1);
        
        // Create integer arrays for the parts of each operand.
        int firstOperandArray [] = parseOperand(firstOperand);
        int secondOperandArray [] = parseOperand(secondOperand);
        if (firstOperandArray [2] == 0 || secondOperandArray [2] == 0) {
        	throw new IllegalArgumentException("Cannot divide by zero.");
        }
        firstOperandArray = toImproperFrac(firstOperandArray[0], firstOperandArray[1], firstOperandArray[2]);
        secondOperandArray = toImproperFrac(secondOperandArray[0], secondOperandArray[1], secondOperandArray[2]);
        
        // Create a third integer array to hold the values after the operation method is called.
        int [] combinedOperandArray= new int [3];
        // Test to find out what operator is being used, call different operation methods depending on operator
        // Set result to the value returned from the operation method
        if (operator.equals(" + ")) {
        	 combinedOperandArray = addFrac(firstOperandArray, secondOperandArray);
        }
        else {
        	if (operator.equals(" - ")) {
        		combinedOperandArray = subtractFrac(firstOperandArray, secondOperandArray);
        	}
        	else {
        		if (operator.equals(" * ")) {
        			combinedOperandArray = multiplyFrac(firstOperandArray, secondOperandArray);
        		}
        		else {
        			if (operator.equals(" / ")) {
        				combinedOperandArray = divideFrac( firstOperandArray, secondOperandArray);
        			}
        			else {
        				throw new IllegalArgumentException("Input is in an invalid format.");
        			}
        		}      		
        	}
        }
        combinedOperandArray=reduceFrac(combinedOperandArray);
        if (combinedOperandArray[1]==0) {
        	return "" + combinedOperandArray[0];
        }
        if (combinedOperandArray[0]==0) {
        	return "" + combinedOperandArray[1] + "/" + combinedOperandArray[2];
        } else {
    		return ""  + combinedOperandArray[0] + "_" + combinedOperandArray[1] + "/" + combinedOperandArray[2];
        }
    }
    // Parse an operand into three parts: whole, numerator, and denominator.
    public static int [] parseOperand(String operand) {
        // Set default values for whole, numerator and denominator.
    	int whole = 0;
        int numerator = 0;
        int denominator = 1;
        if (operand.indexOf("_") > 0) {// Test if there is a whole number.
        	whole = Integer.valueOf(operand.substring(0, operand.indexOf("_")));
        }
        	if (operand.indexOf("/") < 0) {// Test if there is a fraction.
        		whole = Integer.valueOf(operand);
        	}
        	else {
        	numerator = Integer.valueOf(operand.substring(operand.indexOf("_") + 1, operand.indexOf("/")));
        	denominator = Integer.valueOf(operand.substring(operand.indexOf("/") + 1));
        	}
        // Create and return an array with the whole, numerator and denominator of the operand.
        int operandArray [] = new int [] {whole, numerator, denominator};
        return operandArray;
    }
    // Convert a mixed number into an improper fraction.
    // modified from Calc. Library.
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
    	if (whole >= 0){
    	numerator = ((whole * denominator) + numerator);
    	} else {
    		whole *= -1;
    		numerator = ((whole * denominator) + numerator);
    		numerator *= -1;
    	}
    	int returnArray[] = new int [] {0, numerator, denominator};
    	return returnArray;   	
    }
    // Add two fractions or mixed numbers.
    public static int [] addFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	int [] returnArray = new int [3];
    	returnArray [2]= firstOperandArray[2] * secondOperandArray[2];
    	returnArray [1]= (firstOperandArray[1] * secondOperandArray[2]) + (secondOperandArray[1] * firstOperandArray[2]);
    	return returnArray;
    }
    // Subtract two fractions or mixed numbers.
    public static int [] subtractFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	int [] returnArray = new int [3];
    	returnArray [2]= firstOperandArray[2] * secondOperandArray[2];
    	returnArray [1]= (firstOperandArray[1] * secondOperandArray[2]) - (secondOperandArray[1] * firstOperandArray[2]);
    	return returnArray;
    }
    // Multiply two fractions or mixed numbers.
    public static int [] multiplyFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	// Test if each operand is a mixed number, convert to an improper fraction if it is.
    	// Create an integer array to hold the new values and to return.
    	int [] returnArray = new int [3];
    	returnArray[1] = firstOperandArray[1] * secondOperandArray[1];
    	returnArray[2] = firstOperandArray[2] * secondOperandArray[2];
    	return returnArray;
    }
    // Divide two fractions or mixed numbers.
    public static int [] divideFrac(int [] firstOperandArray, int [] secondOperandArray) {
    	// Test if each operand is a mixed number, convert to an improper fraction if it is.
    	// Create an integer array to hold the new values and to return.
    	if (secondOperandArray[1]==0) {
    		throw new IllegalArgumentException("Cannot divide by zero.");
    	}
    	int [] returnArray = new int [3];
    	returnArray[1] = firstOperandArray[1] * secondOperandArray[2];
    	returnArray[2] = firstOperandArray[2] * secondOperandArray[1];
    	return returnArray;
    }
    public static int [] reduceFrac(int [] combinedOperandArray) {//needs to be fixed
    	int gcf;
    	int returnArray[]= combinedOperandArray;
    	returnArray = toImproperFrac(returnArray[0], returnArray[1], returnArray[2]);
    	if (returnArray[2]<0) {//make sure the denominator is positive
    		returnArray[2] *= -1;
    		returnArray[1] *= -1;
    	}	
    	returnArray[0] += returnArray[1]/returnArray[2];
    	returnArray[1] = returnArray[1]%returnArray[2];
    	if(returnArray[0]!=0 && returnArray[1]<0) {
    		returnArray[1] *= -1;	
    	}
    	gcf = gcf(returnArray[1], returnArray[2]);
    	returnArray[1] /= gcf;
    	returnArray[2] /= gcf;
    	return returnArray;
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
    	} else {
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