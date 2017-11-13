//James Lee 
//11/8/2017
package fracCalc;
import java.util.*;
public class FracCalcCheckpoint2 {

    public static void main(String[] args) {
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	//System.out.println("Enter fraction string.");
    	String input = " ";
    	while (!input.toLowerCase().contains("quit")) {
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
    	
    	//Create variable for first operand, and the parts of the first operand
        String firstOperand = input.substring(0, input.indexOf(" "));
        int whole1 = 0;
        int numerator1 = 0;
        int denominator1 = 1;
        if (firstOperand.indexOf("_") > 0) {
        	whole1 = Integer.valueOf(firstOperand.substring(0, firstOperand.indexOf("_")));
        }
        else {
        	if (firstOperand.indexOf("/") < 0) {
        		whole1 = Integer.valueOf(firstOperand);
        	}
        }
        if (firstOperand.indexOf("/") > 0) {
        	numerator1 = Integer.valueOf(firstOperand.substring(firstOperand.indexOf("_") + 1, firstOperand.indexOf("/")));
        	denominator1 = Integer.valueOf(firstOperand.substring(firstOperand.indexOf("/") + 1));
        }   
        
        //Create a variable to store the operator
        String operator = input.substring((input.indexOf(" ")+ 1)); 
        
        //Create variables for the second operand and the parts of the second operand
        String secondOperand = input.substring(input.lastIndexOf(" ") + 1);
        int whole2 = 0;
        int numerator2 = 0;
        int denominator2 = 1;
        if (secondOperand.indexOf("_") > 0) {
        	whole2 = Integer.valueOf(secondOperand.substring(0, secondOperand.indexOf("_")));
        }
        else {
        	if (secondOperand.indexOf("/") < 0) {
        		whole2 = Integer.valueOf(secondOperand);
        	}
        }
        if (secondOperand.indexOf("/") > 0) {
        	numerator2 = Integer.valueOf(secondOperand.substring(secondOperand.indexOf("_") + 1, secondOperand.indexOf("/")));
        	denominator2 = Integer.valueOf(secondOperand.substring(secondOperand.indexOf("/") + 1));
        }
        //Return a description of the second operand
        return "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}