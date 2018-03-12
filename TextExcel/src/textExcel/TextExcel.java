package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

import java.io.*;

public class TextExcel {
	public static void main(String[] args) {
		Grid grid = new Spreadsheet();
		String gridOne = grid.processCommand("A1 = \"oNe\"");
		String accessorOne = grid.getGridText();
		String gridTwo = grid.processCommand("L20 = \"TWo\"");
		String gridOnlyTwo = grid.processCommand("clear A1");
		System.out.println(grid.getGridText());
	    Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}
