package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

import java.io.*;

public class TextExcel {
	public static void main(String[] args) {
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
