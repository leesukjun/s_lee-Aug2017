//James Lee
//Warm up 10/12/2017
public class Hourglass {
	public static void main(String[] args) {
		cap();
		topHalf();
		middle();
		bottomHalf();
		cap();
	}
	public static void cap(){
		System.out.print("|");
		for (int i = 1; i<=10;i++){
			System.out.print("\"");
		}
		System.out.println("|");
	}
	public static void topHalf(){
		int colonDecrement = 0;
		for (int i=1; i <=4; i++){
			for (int j=1; j<=i; j++){
				System.out.print(" ");
			}
			System.out.print("\\");
			for (int j=4; j> colonDecrement; j--) { 
				System.out.print("::");
			}
			System.out.println("/");
			colonDecrement++;
			}
		}
	public static void middle() {
		System.out.println("     ||     ");
	}
	public static void bottomHalf(){
		int colonIncrement = 1;
		for (int i=4; i >=1; i--){
			for (int j=1; j<=i; j++){
				System.out.print(" ");
			}
			System.out.print("/");
			for (int j=1; j<=colonIncrement; j++) { 
				System.out.print("::");
			}
			System.out.println("\\");
			colonIncrement++;
		}
	}
}
