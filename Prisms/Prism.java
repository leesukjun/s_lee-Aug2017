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


public abstract class Prism extends ThreeDShape
{
	private double height;
	
	public Prism(double height) {
		super();
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
	public double round2(double operand) {
		return super.round2(operand);
	}	
}
	