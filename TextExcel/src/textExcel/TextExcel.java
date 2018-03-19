package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;

import java.io.*;

public class TextExcel {
	public static void main(String[] args) {
		Spreadsheet grid = new Spreadsheet();
		grid.processCommand("A1 = \"rocking\"");
		grid.processCommand("B1 = \"bae\"");
		grid.processCommand("C1 = \"xylophone\"");
		grid.processCommand("D1 = \"aerospace\"");
		grid.processCommand("soRTa A1-D1");
		System.out.println(grid.getGridText());
		System.out.println(grid.getCell(new TestLocation(0,0)).fullCellText());
	    Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}
