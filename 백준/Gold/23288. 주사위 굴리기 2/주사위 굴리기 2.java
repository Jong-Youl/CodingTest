import java.io.*;
import java.util.*;

public class Main {
	public static class Dice {
		int dir, r, c;
		// 윗면, 상, 우, 좌, 하, 아랫
		int[] faces = {1, 2, 3, 4, 5, 6};

		public Dice() {
			this.dir = 0;
			this.r = 1;
			this.c = 1;
		}

		void roll(int newDir) {
			this.dir = newDir;
			int[] newFaces = faces.clone();
			switch (newDir) {
				case 0: // 동쪽
					faces[0] = newFaces[3];
					faces[2] = newFaces[0];
					faces[3] = newFaces[5];
					faces[5] = newFaces[2];
					break;
				case 1: // 남쪽
					faces[0] = newFaces[1];
					faces[1] = newFaces[5];
					faces[4] = newFaces[0];
					faces[5] = newFaces[4];
					break;
				case 2: // 서쪽
					faces[0] = newFaces[2];
					faces[2] = newFaces[5];
					faces[3] = newFaces[0];
					faces[5] = newFaces[3];
					break;
				case 3: // 북쪽
					faces[0] = newFaces[4];
					faces[1] = newFaces[0];
					faces[4] = newFaces[5];
					faces[5] = newFaces[1];
					break;
			}
		}

		int getBottom() {
			return faces[5];
		}
	}

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int score = 0;
		Dice d = new Dice();
		for (int i = 0; i < K; i++) {
			int nr = d.r + dr[d.dir];
			int nc = d.c + dc[d.dir];

			if (nr < 1 || nr > N || nc < 1 || nc > M) {
				d.dir = (d.dir + 2) % 4;
				nr = d.r + dr[d.dir];
				nc = d.c + dc[d.dir];
			}

			d.r = nr;
			d.c = nc;
			d.roll(d.dir);

			int A = d.getBottom();
			int B = map[d.r][d.c];

			if (A > B) {
				d.dir = (d.dir + 1) % 4;
			} else if (A < B) {
				d.dir = (d.dir + 3) % 4;
			}

			boolean[][] visit = new boolean[N + 1][M + 1];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{d.r, d.c});
			visit[d.r][d.c] = true;
			int cnt = 1;

			while (!q.isEmpty()) {
				int[] curr = q.poll();

				for (int j = 0; j < 4; j++) {
					nr = curr[0] + dr[j];
					nc = curr[1] + dc[j];
					if (nr < 1 || nr > N || nc < 1 || nc > M) continue;
					if (!visit[nr][nc] && map[nr][nc] == B) {
						q.add(new int[]{nr, nc});
						visit[nr][nc] = true;
						cnt++;
					}
				}
			}

			score += cnt * B;
		}

		System.out.println(score);
	}
}