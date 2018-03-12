package textExcel;

public class FormulaCell extends RealCell {
	Cell [][] newSpreadsheet = Spreadsheet.spreadsheet;
	public FormulaCell(String userInput) {
		super(userInput);
	}
	
	//Returns the value of the evaluated formula truncated to ten spaces
	public String abbreviatedCellText() {
		String data = "" + this.getDoubleValue();
		String returnString = data;
		if(data.length() > 10) {
			return(data.substring(0, 10));
		} else {
			for(int i = 0; i < 10 - data.length(); i++) {
				returnString += " ";
			}
			return returnString;
		}
	}
	public double getDoubleValue() {
		String [] arr = getUserInput().substring(2, getUserInput().length()-2).split(" ");//take out space and parenthesis
		double value = 0.0;
		double value2 = 0.0;
		if(arr[0].toLowerCase().equals("sum") || arr[0].toLowerCase().equals("avg")) {
			
		}
		if(isNumeric(arr[0].substring(0, 1))) {
			value = Double.valueOf(arr[0]);
		}
		for(int i = 0; i < arr.length - 1; i += 2) {
			if(isNumeric(arr[i+2].substring(0, 1))) {
				value2 = Double.valueOf(arr[i+2]);
			}
				if(arr[i+1].equals("+")) {
					value += value2;
				}
				else {
					if(arr[i+1].equals("-")) {
						value -= value2;
					}
					else {
						if(arr[i+1].equals("*")) {
							value *= value2;
						}
						else {
							if(arr[i+1].equals("/")) {
								value /= value2;
							}
						}
					}	
				}
		}
		return value;
	}
	
	//Tests if a string is numeric (only containing numbers, a '.', or a '-')
	public boolean isNumeric(String input) {
		String testString;
		boolean returnValue = true;
		if(input.charAt(0) == '-') {			
			testString = input.substring(1);			
		} else {
			testString = input;	
		}
		for(int i = 0; i < testString.length(); i ++) {
			if(testString.charAt(i) != '.') {
				if(!Character.isDigit(testString.charAt(i))) {
					return !returnValue;
				}
			}
		}
		return returnValue;
	}
}
