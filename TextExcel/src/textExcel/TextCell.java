package textExcel;

public class TextCell implements Cell {
	private String cellContents;

	public TextCell(String contents) {
		cellContents = contents;
	}
	
	public String abbreviatedCellText() {
		String newCellContents = cellContents;
		if (cellContents.contains("\"")){
			newCellContents = cellContents.substring(1, cellContents.length()-1);
		}
		int count = newCellContents.length();
		if(count> 10) {
			return(cellContents.substring(0, 10));
		} else {
			for(int i = 0; i < 10 - count; i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	}

	public String fullCellText() {
		String newCellContents = "\"" + cellContents + "\"";
		return cellContents;
	}
	
	public void setContents(String newContents){
		cellContents = newContents;
	}
}