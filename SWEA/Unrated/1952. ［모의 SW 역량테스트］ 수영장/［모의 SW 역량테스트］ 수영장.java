import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int [] pay;
	public static int [] plan;
	public static int [] dp;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			pay = new int [4];
			plan = new int [13];
			dp = new int [13];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i ++) {
				pay[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i ++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			for(int i = 1; i <= 12; i++) {
				int day = plan[i] * pay[0] + dp[i-1];
				int month = pay[1] + dp[i-1];
				dp[i] = Math.min(day, month);
				if(i >= 3) {
					int treeMonth = pay[2] + dp[i-3];
					dp[i] = Math.min(dp[i], treeMonth);
				}
				if(i == 12) {
					int year = pay[3];
					dp[i] = Math.min(dp[i], year);
				}
			}
			sb.append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}
}