
public class ThreeDShape {
	private double volume;
	private double surfaceArea;

	public ThreeDShape(){
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}
	// Can you write this code for this class or does it need to be overridden by every subclass?
	public double calcVolume(){//this could be abstract. As there can't be just ThreeDShape. So has to be overridden by every subclass.
	return 0;
	}

	// Can you write this code for this class or does it need to be overridden by every subclass?
	public double calcSA(){
	return 0;
	}
	
	public double round2(double operand) {
		double one = Math.abs((int)(operand * 10));//absolute value of input*100 which includes two decimal place values
		double round2 = Math.abs(operand);//absolute value of the input 
		if (10*round2-one >=0.5) {//if greater than 0.5, it means the 3rd decimal would be rounded up
			round2 = (int) (round2 * 10 + 1);
			round2 = round2/10;
		} else {
			round2 = (int) (round2 * 10);
			round2 = round2/10;
		}
		if (operand<=0){
			round2 = round2 * -1;//if the input was negative, convert the round2 to negative value
		}
		return round2;
	}	
}