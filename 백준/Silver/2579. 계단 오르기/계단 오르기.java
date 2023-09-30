import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int [] stair, res;
	public static int N, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stair = new int [N+1];
		res = new int [N+1];

		for(int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		res[1] = stair[1];
		if (N > 1) res[2] = res[1] + stair[2];
		
		System.out.println(dp(N));
		
	}

	private static int dp(int N) {
		if(N < 3) return res[N];
		
		for(int i = 3; i <= N; i++) {
			res[i] = Math.max(res[i-2], res[i-3] + stair[i-1]) + stair[i];
		}
		return res[N];
	}
}