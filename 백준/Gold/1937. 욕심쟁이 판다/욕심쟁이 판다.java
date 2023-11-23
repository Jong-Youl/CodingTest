import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		max = -1;

		map = new int[N][N];
		dp = new int [N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
			//어떤 칸에 위치하던 한 칸은 먹으니까 1로 채움
			Arrays.fill(dp[r], 1);
		}

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				dp(r, c);
				max = Math.max(max, dp(r, c));
			}
		}
		
		System.out.println(max);
		
	}

	private static int dp(int r, int c) {
		// 이미 최대값을 저장했다면 그걸로 출력
		if(dp[r][c] != 1) return dp[r][c];
		
		// 없어? 그럼 채워~
		for(int i = 0 ; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//갈 수 있으면 + 1
			if(check(nr, nc) && map[r][c] < map[nr][nc]) {
				//돌다가 채웠을 수도 있으니까 비교
				dp[r][c] = Math.max(dp[r][c], dp(nr, nc) + 1);
			}
		}
		
		return dp[r][c];
	}

	// index range check method
	private static boolean check(int r, int c) {
		if (r >= 0 && c >= 0 && r < N && c < N)
			return true;
		return false;
	}
}