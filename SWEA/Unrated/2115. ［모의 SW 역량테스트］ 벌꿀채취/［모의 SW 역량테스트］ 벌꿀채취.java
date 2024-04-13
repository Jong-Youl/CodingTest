import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M, C, result, max;
	public static int [][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			result = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int [N][N];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			getHoney();
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void getHoney () {
		int maxA = 0;
		int maxB = 0;

		for(int r1 = 0; r1 < N; r1++) {
			for(int c1 = 0; c1 <= N - M; c1++) {
				max = 0;
				getMaxCost(r1, c1, 0, 0, 0);
				maxA = max;

				max = 0;
				for(int c2 = c1 + M; c2 <= N - M; c2++) {
					getMaxCost(r1, c2, 0, 0, 0);
				}

				for(int r2 = r1 + 1; r2 < N; r2++) {
					for(int c3 = 0; c3 <= N-M; c3++) {
						getMaxCost(r2, c3, 0, 0, 0);
					}
				}
				maxB = max;

				result = Math.max(result, maxA + maxB);
			}


		}
	}

	private static void getMaxCost(int r, int c, int cnt, int sum, int pSum) {
		if(cnt == M) {
			if(sum > C) return;

			max = Math.max(max, pSum);
			return;
		}

		getMaxCost(r, c + 1, cnt + 1, sum + map[r][c], pSum + map[r][c] * map[r][c]);
		getMaxCost(r, c + 1, cnt + 1, sum, pSum);
	}

}