import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int mod = 1_000_000_000;
		
		// 0부터 N까지 정수 K개를 더해서 그 합이 N이 되는 경우의 수
		// 1,000,000,000로 나눈 나머지를 출력
		int [][] dp = new int [K + 1][N + 1];
		for(int i = 1; i <= K; i++) {
			dp[i][0] = 1;
		}
		
		// 더한 갯수
		for(int i = 1; i <= K; i++) {
			// 나온 값
			for(int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		
		System.out.println(dp[K][N]);
	}

}