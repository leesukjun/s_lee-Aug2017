//James Lee
/*August 23, 2017
Project 2 -- Use print and println*/
public class Project_2 {

	public static void main(String[] args) {
		System.out.print("hi there1");
		System.out.println("hi there2");
		System.out.println("hi there3");
		// TODO Auto-generated method stub
		String input = "2/5 + 1/2 + 2/7";
		System.out.println(ordinalIndexOf(input, " ", 4));
	}
    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
}
