package textExcel;

public class RealCell implements Cell, Comparable{

	private String data;
	
	//Constructs a new real cell
	public RealCell (String contents) {
		data = contents;
	}
	//Returns the contents of the cell truncated to ten spaces
	public String abbreviatedCellText() {
		String newCellContents = data;
		if(data.length() > 10) {
			return(data.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - data.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	
	}
	//Returns the non-truncated contents of the cell
	public String fullCellText() {
		String newCellContents = data;
		return newCellContents;
	}
	
	//Returns the double value of a real cell
	public double getDoubleValue() {
		return Double.parseDouble(data);
	}
	
	//Returns the line of user input that was used to make the cell
	public String getUserInput() {
		return data;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}