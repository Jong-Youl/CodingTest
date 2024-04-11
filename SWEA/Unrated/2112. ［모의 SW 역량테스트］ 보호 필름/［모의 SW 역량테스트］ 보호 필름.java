import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int D, W, K, min;
	public static int[][] map, backUp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = D;
			map = new int[D][W];
			backUp = new int[D][W];

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					backUp[r][c] = map[r][c];
				}
			}
			comb(0, 0);

			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	public static boolean test(int[][] dummy) {
		p:
		for (int c = 0; c < W; c++) {
			int cnt = 0;
			int tmp = -1;
			for (int r = 0; r < D; r++) {
				if (tmp == dummy[r][c]) {
					cnt++;
				} else {
					tmp = dummy[r][c];
					cnt = 1;
				}
				if (cnt == K) {
					continue p;
				}
			}
			return false;
		}
		return true;
	}

	public static void copy(int idx) {
		for (int c = 0; c < W; c++) {
			map[idx][c] = backUp[idx][c];
		}
	}

	//IDX는 ROW, DEPTH는 투약 룃수
	public static void comb(int idx, int depth) {
		if (min <= depth || depth == D) {
			return;
		}
		if (idx == D) {
			if (test(map)) {
				min = depth;
			}
			return;
		}

		comb(idx + 1, depth);

		// int[] backUp = new int[W];
		// for (int j = 0; j < W; j++) {
		// 	backUp[j] = map[idx][j];
		// }

		for (int j = 0; j < W; j++) {
			map[idx][j] = 0;
		}
		comb(idx + 1, depth + 1);

		for (int j = 0; j < W; j++) {
			map[idx][j] = 1;
		}
		comb(idx + 1, depth + 1);

		copy(idx);
	}
}