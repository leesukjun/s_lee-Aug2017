package textExcel;

public class TextCell implements Cell {

	private String cellContents;
	
	public TextCell(String contents) {
		cellContents = contents;
	}
	public String abbreviatedCellText() {
		String newCellContents = cellContents;
		if(newCellContents.length() > 10) {
			return(newCellContents.substring(0, 10));
		} else {
			for(int i = 0; i < 10 - newCellContents.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	}
	public String fullCellText() {
		return cellContents;
	}
	
	public String fullCellText1() {
		String newCellContents = "\"" + cellContents + "\"";
		return newCellContents;
	}
	
	public void setContents(String newContents){
		cellContents = newContents;
	}
}