import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int min;
	public static int [] red, green, blue;
	public static int [][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		
		red = new int [N+1];
		green = new int [N+1];
		blue = new int [N+1];
		dp = new int [N+1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			red[i] = Integer.parseInt(st.nextToken());
			green[i] = Integer.parseInt(st.nextToken());
			blue[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][0] = red[1];
		dp[1][1] = green[1];
		dp[1][2] = blue[1];
		
		fill(N);
		
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N][i]);
		}
		
		System.out.println(min);
	}

	private static void fill(int N) {
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red[i];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green[i];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue[i];
		}
		
	}
	
	
}