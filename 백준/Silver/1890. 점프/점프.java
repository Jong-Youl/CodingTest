import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static long total = 0;
	public static long cnt = 0;
	public static int N;

	public static int [][] map;
	public static long [][]dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		dp = new long [N][N];

		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = -1;
			}
		}
		System.out.println(jumpKing(0, 0));
	}

	private static long jumpKing(int r, int c) {
		if(r == N-1 && c == N-1) {
			return 1;
		}

		if(dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;

		int nr = r + map[r][c];
		int nc = c + map[r][c];

		if(nr >= 0 && nr < N) dp[r][c] += jumpKing(nr, c);
		if(nc >= 0 && nc < N) dp[r][c] += jumpKing(r, nc);

		return dp[r][c];
	}
}