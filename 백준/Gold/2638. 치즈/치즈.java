import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb;
	public static int N, M, time, total;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] map;
	public static boolean [][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = 0;
		total = 0;
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				total += map[r][c];
			}
		}
		//아무것도 없을 떄 그냥 출력
		if (total == 0)
			sb.append(0);
		else
			simulation();

		System.out.println(sb);
	}

	// 한바퀴 돌면서 주변 확인
	private static void simulation() {
		while (true) {
			visit = new boolean[N][M];
			checkRealOxygen();
			List<int[]> lst = search();
			if (lst.isEmpty()) break;
			remove(lst);
			time++;
		}
		sb.append(time);
	}

	private static void checkRealOxygen() {
		Queue<int []> q = new LinkedList<>();
		q.add(new int [] {0, 0});
		visit[0][0] = true;
		while (!q.isEmpty()){
			int [] tmp = q.poll();

			for(int i = 0; i < 4; i++) {
				//옆에 공기면 담음
				int r = tmp[0] + dr[i];
				int c = tmp[1] + dc[i];
				if(checkIndex(r,c) && map[r][c] == 0 && !visit[r][c]) {
					visit[r][c] = true;
					q.add(new int [] {r,c});
				}
			}
		}
	}

	private static void remove(List<int[]> lst) {
		for (int[] pos : lst) {
			map[pos[0]][pos[1]] = 0;
		}
	}

	private static List<int[]> search() {
		List<int[]> lst = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					int count = 0;
					for (int i = 0; i < dr.length; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (checkIndex(nr, nc)) {
							if (map[nr][nc] == 0){
								if(!visit[nr][nc]) continue;
								count++;
							}
							if (count == 2) {
								lst.add(new int[] {r, c});
								break;
							}
						}
					}
				}
			}
		}
		return lst;
	}

	private static boolean checkIndex(int r, int c) {
		return (r < N && r >= 0 && c < M && c >= 0);
	}
}