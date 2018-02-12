/* Write this abstract class called Prism.  It has one private field (height) and a constructor.  
 * It contains the methods calcAreaOfBase, calcPerimeter, calcVolume, and calcSA.
 * None of these methods require parameters.   
 * A couple are abstract - can you tell which ones and why?
 * 
 * Math note:
 * The volume of any prism can be found by multiplying the area of the base by the height.
 * The surface area of any prism can be found by multiplying the perimeter of the base by the height
 *   and then adding on the areas of the 2 bases.
 */


public abstract class Prism  
{
	protected double height;
	protected double perimeter;
	protected double base;
	
	public Prism(double height) {
		this.height = height;
	}
	
	public abstract double calcAreaOfBase();	
	public abstract double calcPerimeter();
	public double calcSA() {
		return round2(calcPerimeter() * height + 2*calcAreaOfBase());
	}
	
	public double calcVolume() {
		return round2(calcAreaOfBase() * height);
	}
	private static double round2(double operand) {
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
	