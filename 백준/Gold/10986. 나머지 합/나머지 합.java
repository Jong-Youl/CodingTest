import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long result = 0;

		long [] sum = new long [N];
		long [] cnt = new long [M];

		// O(N)
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			if(i == 0) sum[i] = Integer.parseInt(st.nextToken()) % M;
			else sum[i] = (Integer.parseInt(st.nextToken()) + sum[i-1]) % M;
			
			if(sum[i] == 0) result++;
			cnt[(int) sum[i]]++;
		}
		//O(M)
		for(int i = 0; i < M; i++) {
			if(cnt[i] > 1) result += (cnt[i] * (cnt[i] - 1) / 2);
		}
		//O(N+M)
		System.out.println(result);
	}
}