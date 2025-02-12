import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int maxSize = 10_001;
		int [] dp = new int [maxSize];
		Arrays.fill(dp, 1);
		for(int i = 2; i < maxSize; i++) 
			dp[i] += dp[i - 2];			
		for(int i = 3; i < maxSize; i++) 
			dp[i] += dp[i - 3];
						
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++) {
			int target = sc.nextInt();
			sb.append(dp[target]).append("\n");
		}
		
		sc.close();
		System.out.println(sb);
	}
}