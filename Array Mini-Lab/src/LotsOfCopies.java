/*James Lee
 * 31 October 2017
 * Mini Lab (done individually)
 * 
 * When we set one variable to equal another and then change the original variable to something else, int and Strings stay the same, but array is changed. 
 * After using the method, all values were updated according to what have been changed ion the method changeMe
*/

import java.util.Arrays;
public class LotsOfCopies {
	public static void main (String [] args){
		int num = 7;
		String strMain = "APCS";
		int [] arrMain = {1, 2, 3, 4, 5};
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
		System.out.println(num + " " + strMain + " " + Arrays.toString(arrMain));//Old Values
		System.out.println(num2 + " " + strMain2 + " " + Arrays.toString(arrMain2));//New Values
		changeMe(num, strMain, arrMain);//Part 1
		System.out.println(num + " " + strMain + " " + Arrays.toString(arrMain));//Old Values after using the method changeMe
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