import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static long [][] dp = new long [31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		// 처음에는 'W'만 마지막은 'H'만 쓸 수 있음
		dp[1][0] = 1;
		bottom_up(30, 30);
		
		while(N != 0) {
			sb.append(dp[N][N]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}

	private static long bottom_up(int r, int c) {
		if(r < 0 || c < 0) return 0;
		if(dp[r][c] != 0) return dp[r][c];
		if(r == c) return dp[r][c] = bottom_up(r, c-1);
		return dp[r][c] = bottom_up(r - 1, c) + bottom_up(r, c-1);
	}
}