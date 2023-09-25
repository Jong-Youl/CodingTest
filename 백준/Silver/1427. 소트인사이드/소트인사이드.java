import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); 
		
		String [] arr = str.split("");
		int [] arr2 = new int[arr.length]; 
		
		for(int i = 0; i<arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]); 
		}
		
		Arrays.sort(arr2);
		
//		System.out.println(Arrays.toString(arr2));
		
		for(int i = arr.length-1; i>=0; i--) {
			
			System.out.print(arr2[i]);
		}
		
	}
}
