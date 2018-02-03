import java.util.Scanner;

/**
 * This is my first program
 * @author APCS2
 *8.21.2017
 */
public class Hello_world {

	public static void main(String[] args) {
		int a = 15;
		int [] arg = {0, 1, 2, 3};
		change(a, arg);
		System.out.println(a + "	" + arg[2]);
	}
	public static void change(int am, int [] inm) {
		am = 5;
		inm[2]=0;
	}
}
