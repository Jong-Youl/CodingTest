import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n = 6;
		int[] chess = {1,1,2,2,2,8};
		int[] arr = new int[n];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			
			System.out.print(chess[i] - arr[i] + " ");
		}
	}
}

