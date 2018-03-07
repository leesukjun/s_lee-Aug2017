package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int columnNumber;
	private int rowNumber;

    public int getRow() {
        return rowNumber;
     }

    public int getCol() {
        return columnNumber;
    }
    
    public SpreadsheetLocation(String cellName){
    	columnNumber = Character.getNumericValue(cellName.charAt(0)) - 10;
    	rowNumber = Integer.parseInt(cellName.substring(1)) - 1;
    	}
}
