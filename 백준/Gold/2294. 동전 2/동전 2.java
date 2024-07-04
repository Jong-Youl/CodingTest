import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int [] dp, coin;
	public static int inf = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		coin = new int [N];
		dp = new int [K+1];
		Arrays.fill(dp, inf);
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			if(coin[i] > K) continue;
			dp[coin[i]] = 1;
		}
		
		Arrays.sort(coin);
		
		for(int i = 0; i < N; i++) {
			if(coin[i] == 0) continue;
			if(i < N-1 && coin[i] == coin[i+1]) continue;
			for(int j = coin[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		
		int res = dp[K] == inf ? -1 : dp[K];
		System.out.println(res);
	}

}