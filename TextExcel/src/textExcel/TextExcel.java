package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class TextExcel {
	public static void main(String[] args) {
	    Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}
