import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int W, H, K, min;
	public static int[][] zoo;
	public static boolean[][][] visit;

	// 원숭이처럼 걷기 상하좌우
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	// 말처럼 달리기
	public static int[] jump_r = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int[] jump_c = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 이 만큼만 말처럼 뛸 수 있음
		K = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		zoo = new int[H][W];
		visit = new boolean[H][W][K + 1];

		// 동물원 정보 입력
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				zoo[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, K, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static void bfs(int row, int col, int jump, int cnt) {
		// 행, 열, 점프 가능 횟수, 길이
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { row, col, jump, cnt });

		while (!q.isEmpty()) {

			int[] v = q.poll();

			int r = v[0];
			int c = v[1];
			int k = v[2];
			int res = v[3];
			
			if (r == H - 1 && c == W - 1) {// 도착해야 갱신
				min = Math.min(min, res);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				
				// 인덱스 안벗어나고 간적 없으며 장애물이 아니면
				if (check(nr, nc) && !visit[nr][nc][k] && zoo[nr][nc] == 0) {	
					visit[nr][nc][k] = true;
					q.add(new int[] { nr, nc, k, res + 1 });
				}
			}

			if (k > 0) {// 뛸 수 있어~~
				for (int i = 0; i < 8; i++) {
					int nr = r + jump_r[i];
					int nc = c + jump_c[i];
					// 인덱스 안벗어나고 간적 없으며 장애물이 아니면
					if (check(nr, nc) && !visit[nr][nc][k - 1] && zoo[nr][nc] == 0) {
						visit[nr][nc][k - 1] = true;
						q.add(new int[] { nr, nc, k - 1, res + 1 });
					}
				}
			}

		}
	}

	public static boolean check(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W)
			return true;

		return false;
	}

}