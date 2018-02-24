
public class Sphere extends ThreeDShape{
	private double radius;
	
	public Sphere(double radius) {
		super();
		this.radius = radius;
	}
	public double calcVolume(){
		double volume = 4.0/3.0 * Math.PI * radius * radius * radius;
		return round2(volume);
	}
	public double calcSA(){
		double area = 4.0 * Math.PI * radius * radius;
		return round2(area);
	}
}
