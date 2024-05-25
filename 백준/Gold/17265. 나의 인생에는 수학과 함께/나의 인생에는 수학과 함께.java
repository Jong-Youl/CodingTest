import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, max, min;
	public static int[] dr = {1, 0};
	public static int[] dc = {0, 1};
	public static char[][] map;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = st.nextToken().charAt(0);
			}
		}
		sb.append(map[0][0]);
		dfs(0, 0, sb);

		System.out.println(max + " " + min);
	}

	private static boolean checkIndex(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return false;
		return true;
	}

	private static void dfs(int r, int c, StringBuilder sb) {
		if (r == N - 1 && c == N - 1) {
			int sum = sb.charAt(0) - '0';
			for (int i = 1; i < sb.toString().length(); i++) {
				switch (sb.charAt(i)) {
					case '+':
						sum += sb.charAt(++i) - '0';
						break;
					case '-':
						sum -= sb.charAt(++i) - '0';
						break;
					case '*':
						sum *= sb.charAt(++i) - '0';
						break;
				}
			}

			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!checkIndex(nr, nc))
				continue;
			StringBuilder tmp = new StringBuilder().append(sb).append(map[nr][nc]);
			dfs(nr, nc, tmp);
		}
	}
}