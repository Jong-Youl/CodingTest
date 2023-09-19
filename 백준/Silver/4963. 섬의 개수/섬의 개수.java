import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;
	public static int[][] map;
	public static boolean[][] visit;
	public static int W, H, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());// 너비
		H = Integer.parseInt(st.nextToken());// 높이
		
		int tc = 0;
		
		while (!(W + H == 0)) {// 너비 높이가 마지막에 0 0으로 나오면 종료
			// 지도 크기 설정
			
			map = new int[H][W];
			visit = new boolean[H][W];
			
			tc++;
			cnt = 0;// 섬의 갯수

			// 지도 정보 입력
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 0) {// 만약 바다면 갈 수 없으니까 visit - true 체크
						visit[r][c] = true;
					}
				}
			}
			// 섬 개수 찾기(바다는 전부 true라서 false일때 탐색 ㄱ)
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (!visit[r][c]) {// 육지면 지금 밟은 자리 true로 체크하고 나아감
						cnt++;
						check(r, c);
					}
				}
			}

			sb.append(cnt).append("\n");

			// 지도 크기 재설정
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		
		}
		System.out.println(sb);
	}

	public static void check(int r, int c) {// 어디까지가 섬인지 체크
		visit[r][c] = true;

		// 상하좌우 대각선으로 움직을 수 있음
		// 상
		if (idx_check(r - 1, c) && !visit[r - 1][c]) {// 위에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r - 1, c);
		}
		// 하
		if (idx_check(r + 1, c) && !visit[r + 1][c]) {// 아래 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r + 1, c);
		}
		// 좌
		if (idx_check(r, c - 1) && !visit[r][c - 1]) {// 왼쪽에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r, c - 1);
		}
		// 우
		if (idx_check(r, c + 1) && !visit[r][c + 1]) {// 오른쪽에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r, c + 1);
		}
		// 우상
		if (idx_check(r - 1, c + 1) && !visit[r - 1][c + 1]) {// 오른쪽 위에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r - 1, c + 1);
		}
		// 우하
		if (idx_check(r + 1, c + 1) && !visit[r + 1][c + 1]) {// 오른쪽 아래에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r + 1, c + 1);
		}
		// 좌상
		if (idx_check(r - 1, c - 1) && !visit[r - 1][c - 1]) {// 왼쪽 위에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r - 1, c - 1);
		}
		// 좌하
		if (idx_check(r + 1, c - 1) && !visit[r + 1][c - 1]) {// 왼쪽 아래에 갈 수 있고 방문한 적 없으면 ㄱㄱ
			check(r + 1, c - 1);
		}

	}

	public static boolean idx_check(int r, int c) {// r - H, c - W
		if (0 <= r && r < H && 0 <= c && c < W) {
			return true;
		}
		return false;
	}
}