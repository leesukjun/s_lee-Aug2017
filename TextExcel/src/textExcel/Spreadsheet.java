package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	static Cell [][] spreadsheet = new Cell [21][13];

	public Spreadsheet() {
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 13; j++) {
				spreadsheet [i][j] = new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command)	{
		int row, column;
		String returnString = "";
		if (command.equals("quit")) {
			returnString = "quit";
		} else {
			if(command.equals("")) {//Returns nothing if the command is blank
				returnString = "";
			} else {
				if (command.length() <= 3 && command.length() != 0) {//Returns the non-truncated contents of a specified cell (cell inspection)
					column = Character.getNumericValue(command.charAt(0)) - 9;
					row = Integer.valueOf((command.substring(1))) ;
					
					returnString = spreadsheet[row][column].fullCellText();
				} else {
					if (command.contains("=")) {//'=' means there is an assignment
						String [] splitInput = command.split(" ", 3);
						SpreadsheetLocation location = new SpreadsheetLocation(splitInput[0]);
					} else {
						
					}
				}
			}
		}
		if(command.toLowerCase().contains("clear ")) {
			String [] splitInput2 = command.split(" ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(splitInput2[1]);
			spreadsheet[location.getRow() + 1][location.getCol() + 1] = new EmptyCell();
			returnString = this.getGridText();	
		} else {
			if(command.toLowerCase().equals("clear")) {
				Cell [][] clearedSpreadsheet = new Cell[21][13];
				for(int i = 1; i < 21; i++) {
					for(int j = 1; j < 13; j++) {
						clearedSpreadsheet [i][j] = new EmptyCell();
					}
				}
				spreadsheet = clearedSpreadsheet;
				returnString = this.getGridText();
			}
		}
		return returnString;
	}

	//Returns the number of rows in the spreadsheet
	public int getRows() {
		return numberOfRows;
	}

	//Returns the number of columns in the spreadsheet
	public int getCols() {
		return numberOfColumns;
	}

	public Cell getCell(Location loc)
	{
		return spreadsheet[loc.getRow() + 1][loc.getCol() + 1];
	}

	public String getGridText() {
		String grid = "";
		char colCount = 'A';
		for(int row = 0; row < 21; row++) {
			for(int col = 0; col < 13; col++) {
				if(row == 0) {
					if(col == 0) {
						grid += "   |";
					}
					else {
						grid += "" + colCount + "         |";
						colCount++;	
					}
				}
				else {
					if (col == 0) {
						if(row < 10) {
							grid += "" + row + "  |";
						}
						else {
							grid += "" + row + " |";
						}		
					}
					else {
						String test = spreadsheet[row][col].abbreviatedCellText();
						if(test.equals("")){
							grid += "          |";
						}
						else{
							grid += test + "|";
						}
					}
				}
			}
		grid += "\n";
		}
	return grid;
	}
}
