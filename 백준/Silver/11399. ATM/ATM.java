import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//줄 서는 사람 수
		int [] arr = new int [N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int result = 0;
		
		for(int i=0; i<N; i++) {
			sum += arr[i];
			result += sum;
		}
		System.out.println(result);
	}
}