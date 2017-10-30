/* James Lee
 * 10.26.2017
 * SplitString 
 */

 //Your task Part 1:
/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
* What if it's a fancy sandwich with multiple pieces of bread?
*/

//Your task Part 2:
/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
* Again, what if it's a fancy sandwich with multiple pieces of bread?
*/
import java.util.Arrays;

public class Split {
	public static void main(String[] args) {//practice
		String[] arr = "I like apples!".split(" ");
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		System.out.println(Arrays.toString("I really like reallyreally red apples".split("really")));
		System.out.println(Arrays.toString("really like really red apples".split("really")));
		System.out.println(Arrays.toString("I really like really red apples,really".split("really")));
		
		System.out.println(sandwichSplit_V1("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(sandwichSplit_V2("apples pineapples bread lettus tomato bacon mayo ham bread cheese"));
	}
	public static void sandwichSplit_V1(String x) {//combine the if statements (use &&)
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
	public static void sandwichSplit_V2(String x) {//combine the if statements (use &&)
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