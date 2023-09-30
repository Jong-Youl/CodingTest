import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int [][] maze, dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int [N+1][M+1];
		dp = new int [N+1][M+1];
		
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				maze[r][c] = Integer.parseInt(st.nextToken());
				if(r == 1) {
					if(c == 1) dp[r][c] = maze[r][c];
					else dp[r][c] = maze[r][c] + dp[r][c-1];
				}
				else {
					if(c == 1) dp[r][c] = maze[r][c] + dp[r-1][c];
					else dp[r][c] = maze[r][c] + dp[r][c-1];
				}
			}
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(check(r, c + 1) && dp[r][c] + maze[r][c + 1] > dp[r][c+1]) dp[r][c+1] = dp[r][c] + maze[r][c + 1]; 
				if(check(r+1, c) && dp[r][c] + maze[r+1][c] > dp[r+1][c]) dp[r+1][c] = dp[r][c] + maze[r+1][c];
				if(check(r+1, c + 1) && dp[r][c] + maze[r+1][c+1] > dp[r+1][c+1]) dp[r+1][c+1] = dp[r][c] + maze[r+1][c+1];
			}
		}

		System.out.println(dp[N][M]);
	}

	private static boolean check(int r, int c) {
		if(r > 0 && c > 0 && r <= N && c <= M) return true;
		
		return false;
	}

}