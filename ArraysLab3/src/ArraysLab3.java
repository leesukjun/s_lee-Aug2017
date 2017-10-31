import java.util.Arrays;
public class ArraysLab3 {
	public static int[] sum (int[] arr1, int[] arr2) {
		assert (arr1.length > 0) && (arr1.length == arr2.length);
		//if arr1 length is not 0 and arr1 and arr2 have same length, arr2's length must be over 0.
		int [] sumArray = new int [arr1.length];
		for ( int i = 0; i < arr1.length; i++) {
			sumArray[i] = arr1[i] + arr2[i];
		}
		return (sumArray);
	}
	public static int[] append(int[] arr, int num){
		assert (arr.length > 0);
		int n = arr.length;
		int [] appendArray = new int [n+1];
		for(int i = 0; i <= n; i++) {
			if(i == n){
				appendArray[n] = num;
			}
			else{
				appendArray[i] = arr[i];
			}
		}
		return(appendArray);
	}
	public static int[] remove(int[] arr, int idx){
		assert (arr.length >= 2) && (idx<=arr.length);//make sure idx is within the length of the array
		int n = arr.length;
		int [] removedArray = new int[n-1];
		int newIndex = 0;
		for (int i = 0; i < n; i++) {
			if(i != idx) {
				removedArray[newIndex] = arr[i];
				newIndex++;
			}
		}
	return(removedArray);
	}
	public static int sumEven(int[] arr){
		assert (arr.length > 0);
		int evenSum = 0;
		for(int i = 0; i < arr.length; i++){
			if(i%2 == 0){
				evenSum += arr[i];
			}
		}
		return(evenSum);
	}
	public static void rotateRight(int[] arr){
		assert (arr.length > 0);
		int last = arr[arr.length-1];
		for (int i = 0; i < arr.length; i++){
			if(i != 0){
			arr[i] = arr[i-1];
		}
		arr[0] = last;
		}
	}
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40, 0, 0,  -10};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56, 0, 15, -15};
		int [] sumArr = sum(a1, a2);
		int appendNum = 200;
		int [] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int [] removeArr = remove(a2, removeIdx);
		int  sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println("sumArr: " + Arrays.toString(sumArr));
		System.out.println("appendArr: " + Arrays.toString(appendArr));
		System.out.println("removeArr: " + Arrays.toString(removeArr));
		System.out.println("sumOfEvens: " + sumOfEvens);
		System.out.println("a1: " + Arrays.toString(a1));
	}
}
