import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static final int N = 1_000_001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = getDivisorSum();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- >0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static long[] getDivisorSum() {
		//각각의 수의 약수합을 담을 배열
		long[] Sum = new long[N];
		
		//1은 모든 수의 약수
		Arrays.fill(Sum, 1);
		
        //1은 추가했으니까 2부터
		for(int i=2; i<N; i++) { 
			for(int j=1; i*j<N; j++) {
				Sum[i*j] += i;
			}
		}
		
		long[] dp = new long[N];
		
		for(int i=1; i<N; i++) {
			dp[i] = dp[i-1] + Sum[i];
		}
		
		return dp;
	}
}