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
		if (command.contains("=")){
			String[] data = command.split(" ", 3);
			SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
			spreadsheet [location.getCol()][location.getRow()]= new TextCell(data[2]);
			return getGridText();
		}
		if (command.length() <= 3 && command.length() != 0) {
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return spreadsheet [location.getCol()][location.getRow()].fullCellText();
		}
		if (command.toLowerCase().equals("clear ")) {
			String [] data = command.split(" ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(data[1]);
			spreadsheet [location.getCol()][location.getRow()]= new EmptyCell();
		} else { 
			if (command.toLowerCase().equals("clear")) {
				for(int i = 0; i < 21; i++) {
					for(int j = 0; j < 13; j++) {
						spreadsheet [i][j] = new EmptyCell();
					}
				}
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
