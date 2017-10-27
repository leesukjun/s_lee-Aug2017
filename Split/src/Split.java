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
	public static String split(String line, String check) {
		for (int i=1; i<=(line.length()-check.length()); i++) {
			if (line.substring(i, check.length())==check) {
				
			}
		}
		return line;
	}
}