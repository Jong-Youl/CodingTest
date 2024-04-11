import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N, max, startR, startC;
	//우상, 우하, 좌하, 좌상
	public static int [] dr = {-1, 1, 1, -1};
	public static int [] dc = {1, 1, -1, -1};
	public static int [][] map;
	public static boolean [] menu;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			simulation();
			if(max == Integer.MIN_VALUE) max = -1;
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	public static void getDessert(int r, int c, int dir, int cnt) {
		for(int i = 0; i < 2; i++) {
			int idx = dir + i;
			//4가 되면은 이미 한바퀴 돈거임
			if(idx == 4) break;

			int nr = r + dr[idx];
			int nc = c + dc[idx];

			if(nr == startR && nc == startC && idx == 3) {
				max = Math.max(max, cnt);
				continue;
			}

			if(0 <= nr && nr < N && 0 <= nc && nc < N && !menu[map[nr][nc]]) {
				menu[map[nr][nc]] = true;
				getDessert(nr, nc, idx, cnt + 1);
				menu[map[nr][nc]] = false;
			}
		}
	}

	public static void simulation () {
		for(int r = 1; r < N - 1; r++) {
			for(int c = 0; c < N - 2; c++) {
				startR = r;
				startC = c;
				// visit = new boolean[N][N];
				// visit[r][c] = true;
				menu = new boolean[101];
				menu[map[r][c]] = true;
				getDessert(r, c, 0, 1);
			}
		}
	}
}