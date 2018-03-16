package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

import java.io.*;

public class TextExcel {
	public static void main(String[] args) {
		String greeting = "ThisIsALongString";
		greeting = "L2 = \"" + greeting + "\"";
				System.out.println(greeting);
				String newGreting = greeting.substring(2, greeting.length()-2);
				System.out.println(newGreting);
		String dog = "\"dog\"";
		System.out.println(dog);
		String newDog = dog.substring(1, dog.length()-1);
		System.out.println(newDog);
		String command = "F2 = ( 1 )";
		String[] data = command.split(" ", 3);
		System.out.println(data[2]);
		System.out.println(data[2].substring(0,1).equals("("));
		
	    Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}
