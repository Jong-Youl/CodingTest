import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, L, R, time;
	public static boolean isOver;
	public static int [] dr = {1, -1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	public static int [][] map;
	public static boolean [][] open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		//땅 크기
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		//최소 최대
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		//땅 입력
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		//BFS 돌리기
		simulation();
		System.out.println(time);
	}
	/*
	 * 국경선을 공유하는 두 나라 L <= 인구 차이 <= R 하루 동안 염
	 * 국경선이 모두 열리면 인구 이동을 시작함
	 * 하루동안 연합으로 됨
	 */
	public static void simulation() {
		
		while (true) {
			open = new boolean[N][N];
			isOver = true;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(open[r][c]) continue;
					bfs(r, c);
				}
			}
			if(isOver) break;
			time++;
		}
	}
	//열어놨으면
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> united = new ArrayList<>();
		int total = 0;

		int [] start = new int []{r, c};
		united.add(start);
		q.add(start);

		open[r][c] = true;
		total += map[r][c];
		while (!q.isEmpty()) {
			int [] tmp = q.poll();

			for(int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];

				if(0 <= nr && nr < N && 0 <= nc && nc < N) {
					//안열렸으면 -> 올떄마다 확인 차이 검사
					//전부 열어놓고 닫는 느낌으로 가면 차이 검사 닫힌건
					if (!open[nr][nc]) {
						int diff = Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]);
						if(diff <= R && diff >= L) {
							int [] target = new int []{nr, nc};
							isOver = false;
							open[nr][nc] = true;
							total += map[nr][nc];
							q.add(target);
							united.add(target);
						}
					}
					//이미 열린 곳이면 그냥 넘김
				}
			}
		}

		if(united.size() == 1) return;
		int dummy = total/united.size();
		for(int [] pos : united) {
			int tr = pos[0];
			int tc = pos[1];
			map[tr][tc] = dummy;
		}
	}
}