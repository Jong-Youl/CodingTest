import java.io.*;
import java.util.*;

/*	
 * 2.5초
 * */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		boolean[][] dp = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int len = 1; len <= N; len++) {
			for (int start = 1; start + len - 1 <= N; start++) {
				int end = start + len - 1;

				if (len == 1)
					dp[start][end] = true;
				else if (len == 2)
					dp[start][end] = (arr[start] == arr[end]);
				else
					dp[start][end] = (arr[start] == arr[end] && dp[start + 1][end - 1]);
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[start][end] ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
}