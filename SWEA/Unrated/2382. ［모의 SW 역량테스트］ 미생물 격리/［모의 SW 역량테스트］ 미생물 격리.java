import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M, K, total;
	public static int [] dr = {0, -1, 1, 0, 0};
	public static int [] dc = {0, 0, 0, -1, 1};
	public static cluster [][] map;
	public static List<cluster> lst;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			total = 0;

			lst = new ArrayList<>();
			//미생물 정보 받기
			//r, c, 미생물 수, 방향
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				lst.add(new cluster(r, c, cnt, dir));
			}
			//이동시키기
			simulation();
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
	public static void simulation() {
		int time = 0;
		while (time < M) {
			//배열 초기화
			map = new cluster[N][N];
			Collections.sort(lst);
			//배열 돌아가면서 이동 정보를 map에 입력 -> K 회 점점 줄어듦
			if (lst.size() > 0) move();
			//map 정보를 다시 배열에 입력
			lst = new ArrayList<>();
			record();
			time++;
		}
		getTotal();
	}
	public static void getTotal() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				//군집이 있으면 넣어줌
				if(map[r][c] != null) total += map[r][c].cnt;
			}
		}
	}

	//다시 lst에 넣어줌
	public static void record() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				//군집이 있으면 넣어줌
				if(map[r][c] != null) lst.add(map[r][c]);
			}
		}
	}
	/*
	 * 이동 시
	 * 1. 약품이 칠해진 칸에 가면 미생물 수 (/2)연산, 방향 반대
	 * 한 마리만 살아 남으면 군집 삭제
	 * 2. 이동 중 합쳐지면 군집 합체 -> 미생물 수는 더하고 더 많은 미생물 수를 가진 군집의 방향을 가져옴
	 * */
	public static void move () {
		for(cluster tmp : lst) {
			int nr = tmp.r + dr[tmp.dir];
			int nc = tmp.c + dc[tmp.dir];
			int cnt = tmp.cnt;
			int dir = tmp.dir;
			// 온적 없다면
			if (map[nr][nc] == null) {
				//격리구역일 때 방향 반대 + 숫자 절반 + 숫자가 만약 1이 되면 없어짐
				if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
					cnt /= 2;
					if (dir == 1) dir = 2;
					else if (dir == 2) dir = 1;
					else if (dir == 3) dir = 4;
					else if (dir == 4) dir = 3;
				}
			}
			// 이미 누가 왔다면(격리구역이 겹치는 경우는 없음)
			else {
				cnt += map[nr][nc].cnt;
			}
			map[nr][nc] = new cluster(nr, nc, cnt, dir);
		}
	}
	public static class cluster implements Comparable <cluster>{
		int r, c, cnt, dir;
		public cluster (int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(cluster o) {
			return this.cnt -o.cnt;
		}
	}
}