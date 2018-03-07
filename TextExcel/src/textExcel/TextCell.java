package textExcel;

public class TextCell implements Cell{
	private String content;
	public TextCell(String content) {
		this.content = content;
	}

	public String abbreviatedCellText() {
		String newCellContents = content;
		if(content.length() > 10) {
			return(content.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - content.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	}

	public String fullCellText() {
		return "\"" + content + "\"";
	}
}
