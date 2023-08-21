import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int [N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int sum = 0;
		
		for(int i = 0; i<k; i++) {
			sum += arr[i];
			max = sum;
		}// 첫 번째 k값
		
		for(int i = 0; i<N-k; i++) {
			sum -= arr[i];
			sum += arr[i+k];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}