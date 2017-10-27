/* James Lee
 * 10.26.2017
 * Split!!!
 */
import java.util.Arrays;

public class Split {
	public static void main(String[] args) {
		String[] arr = "I like apples!".split(" ");
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		System.out.println(Arrays.toString("I really like reallyreally red apples".split("really")));
		System.out.println(Arrays.toString("really like really red apples".split("really")));
		System.out.println(Arrays.toString("I really like really red apples,really".split("really")));
		
	}
	public static void sandwichSplit(String x) {//combine the if statements (use &&)
		if (x.indexOf("bread") >= 0) {
			if (x.lastIndexOf("bread") != x.indexOf("bread") + 5) {
				if (x.lastIndexOf("bread") != x.indexOf("bread")) {
					String y = x.substring(x.indexOf("bread") + 5, x.lastIndexOf("bread"));
					System.out.println(y);
					String[] s = y.split("bread");
					if (s.length > 0) {
					   System.out.println(Arrays.toString(s));
					}
					else {
					   System.out.println("This is not a sandwich");
					}
				}
				else {
					System.out.println("This is not a sandwich");
				}
			}
			else {
				System.out.println("This is not a sandwich");
			}
			}
		else {
		System.out.println("This is not a sandwich");
		}
	}
	public static void sandwichSplitBySpaces(String x) {//combine the if statements (use &&)
		if (x.indexOf("bread") >= 0) {
			if (x.lastIndexOf("bread") != x.indexOf("bread") + 6) {
				if (x.lastIndexOf("bread") != x.indexOf("bread")) {
					String y = x.substring(x.indexOf("bread") + 6, x.lastIndexOf("bread"));
					String[] s = y.split(" ");
					System.out.println(y);
					if (s.length > 0) {
					   System.out.println(Arrays.toString(s));
					}
					else {
					   System.out.println("This is not a sandwich");
					}
				}
				else {
					System.out.println("This is not a sandwich");
				}
			}
			else {
				System.out.println("This is not a sandwich");
			}
		}
		else {
		System.out.println("This is not a sandwich");
		}
	}
}
