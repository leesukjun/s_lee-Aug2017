/*James Lee
 * 31 October 2017
 * Mini Lab (done individually)
 * 
 * When we set one variable to equal another (called b) and then change the original variable to something else, int and String of b stay the same, but array of b is changed. 
 * After using the method with inputs of original values, all original values were changed (or updated according to what have been changed from the method changeMe)
*/

import java.util.Arrays;
public class LotsOfCopies {
	public static void main (String [] args){
		int num = 7;
		String strMain = "APCS";
		int [] arrMain = {1, 2, 3, 4, 5};
		System.out.println(strMain.substring(2,4));
		//new variables
		int num2 = num;
		String strMain2 = strMain;
		int [] arrMain2 = arrMain;
		
		num = 6;
		strMain = "APCS2";
		for(int i = 0; i < arrMain.length; i++) {
			arrMain[i] = i;
		//changing the original value
		}
		System.out.println(num + " " + strMain + " " + Arrays.toString(arrMain));//"a" Values (original)
		System.out.println(num2 + " " + strMain2 + " " + Arrays.toString(arrMain2));//"b" Values
		changeMe(num, strMain, arrMain);//Part 1
		System.out.println(num + " " + strMain + " " + Arrays.toString(arrMain));//Original Values after using the method changeMe
	}
	private static char[] indexOf(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void changeMe (int x, String str, int [] arr) {
		x--;
		str = "APCS2";
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+2;
		}
		System.out.println("Changed: " + x + " " + str + " " + Arrays.toString(arr));
	}
}