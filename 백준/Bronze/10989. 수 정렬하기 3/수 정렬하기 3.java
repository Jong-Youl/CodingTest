import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int [] cnt = new int [max + 1];
		
		for(int i = 0; i < N; i++) {
			cnt[arr[i]]++ ;
		}
		
		for(int i = 1; i <= max; i++) {
			cnt[i] += cnt[i-1];
		}

		int [] sorted = new int [N];
		
		for(int i = N-1; i >= 0; i--) {
			int val = arr[i];
			cnt[val]--;
			sorted[cnt[val]] = val;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(sorted[i]).append("\n");
		}
		System.out.println(sb);
	}
}