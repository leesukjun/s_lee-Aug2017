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


public class Prism  
{
	protected double height;
	protected double perimeter;
	protected double base;
	
	public Prism(double height) {
		this.height = height;
	}
	
	public double calcAreaOfBase() {
		double bas = round2(base);
		return bas;
	}
	
	public double calcPerimeter() {
		double peri = round2(perimeter);
		return peri;
	}
	
	public double calcVolume() {
		double vol = base * height;
		vol = round2(vol);
		return vol;
	}
	
	public double calcSA() {
		double sa = perimeter * height;
		sa = sa + base + base;
		sa = round2(sa);
		return sa;
	}
	private static double round2(double operand) {
		double one = Math.abs((int)(operand * 100));//absolute value of input*100 which includes two decimal place values
		double round2 = Math.abs(operand);//absolute value of the input 
		if (100*round2-one >=0.5) {//if greater than 0.5, it means the 3rd decimal would be rounded up
			round2 = (int) (round2 * 100 + 1);
			round2 = round2/100;
		} else {
			round2 = (int) (round2 * 100);
			round2 = round2/100;
		}
		if (operand<=0){
			round2 = round2 * -1;//if the input was negative, convert the round2 to negative value
		}
		return round2;
	}	
}
	