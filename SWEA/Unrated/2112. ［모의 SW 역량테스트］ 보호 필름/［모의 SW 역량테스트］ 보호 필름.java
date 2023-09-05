import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int D, W, K, res;
	public static int[] format;
	public static int[][] films;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			films = new int[D][W];

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					films[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			performaceTest(0, 0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(res);
			System.out.println(sb);
		}
	}

	public static void performaceTest(int depth, int cnt) {// depth = 필름 깊이, cnt = 약 주입 횟수
		// 탈출
		if (check()) {
			if(res > cnt)
				res = cnt;
			return;
		}
		
		if (depth == D) {// 현재 결과가 앞서 갱신한 최소 주입 횟수와 동일하거나 크다면 종료
			return;
		}
		
		// 대책
		int [] format = new int[W];

		for (int i = 0; i < W; i++) {
			format[i] = films[depth][i];
		}
		// 너넨 돌아라

		// 약 주입 x
		performaceTest(depth + 1, cnt);

		// A약 주입 후 복구
		injection(depth, 0);
		performaceTest(depth + 1, cnt + 1);
		reset(depth, format);

		// B약 주입 후 복구
		injection(depth, 1);
		performaceTest(depth + 1, cnt + 1);
		reset(depth, format);
	}

	public static void injection(int depth, int medicine) {// 0(A) 일때 1(B)일때 그 값 넣음
		for (int i = 0; i < W; i++) {
			films[depth][i] = medicine;
		}
	}

	public static void reset(int depth, int [] format) {// 그전에 만들어 놓은걸로 다시 복구
		for (int i = 0; i < W; i++) {
			films[depth][i] = format[i];
		}
	}

	public static boolean check() {// 0(A) 일때 1(B)일때 그 값 넣음

		p: for (int c = 0; c < W; c++) {
			int cnt_A = 0;
			int cnt_B = 0;
			for (int r = 0; r < D; r++) {
				if (films[r][c] == 0) {
					cnt_A++;
					cnt_B = 0;
				} else if (films[r][c] == 1) {
					cnt_A = 0;
					cnt_B++;
				}

				if (cnt_A == K || cnt_B == K)
					continue p;

			}
			return false;
		}
		return true;
	}
	
}