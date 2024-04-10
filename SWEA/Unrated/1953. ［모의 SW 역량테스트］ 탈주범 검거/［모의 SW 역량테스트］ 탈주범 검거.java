import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int N, M, L;
	public static int result;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	public static int [][] map;
	public static boolean [][] visit;
	public static List<List<Integer>> direction = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int i = 0; i <= 7; i++) {
			direction.add(new ArrayList<>());
		}

		for(int i = 1; i <= 7; i++) {
			if(i == 1) {
				direction.get(i).add(0);
				direction.get(i).add(1);
				direction.get(i).add(2);
				direction.get(i).add(3);
			}
			else if (i == 2) {
				direction.get(i).add(0);
				direction.get(i).add(1);
			}
			else if (i == 3) {
				direction.get(i).add(2);
				direction.get(i).add(3);
			}
			else if (i == 4) {
				direction.get(i).add(0);
				direction.get(i).add(3);
			}
			else if (i == 5) {
				direction.get(i).add(1);
				direction.get(i).add(3);
			}
			else if (i == 6) {
				direction.get(i).add(1);
				direction.get(i).add(2);
			}
			else {
				direction.get(i).add(0);
				direction.get(i).add(2);
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());

			result = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑 위치
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 총 도망 시간
			L = Integer.parseInt(st.nextToken());
			// 지하 크기
			map = new int[N][M];
			visit = new boolean[N][M];

			//정보 받기
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			find(r, c);
			check();
			//결과 더하기
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void check(){
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(visit[r][c]) result++;
			}
		}
	}

	//BFS 탐색
	public static void find(int startR, int startC) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int []{startR, startC, 1});

		visit[startR][startC] = true;

		while(!q.isEmpty()) {
			int [] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int curTime = tmp[2];
			//시간 딱 맞으면 더 이상 안감
			if(curTime == L) return;
			// 터널 타입
			int type = map[r][c];

			for(int i = 0; i < direction.get(type).size(); i++) {
				int idx = direction.get(type).get(i);
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				// 인덱스 검사 && 방문 여부 검사
				if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && !visit[nr][nc]) {
					if(!canConnect(idx, map[nr][nc])) continue;
					visit[nr][nc] = true;
					q.offer(new int [] {nr, nc, curTime + 1});
				}
			}
		}
	}

	public static boolean canConnect(int idx, int next) {
		//idx에 따라서 다음 배관으로 이동할 수 있는지 확인
		//아래서 올라온거일때
		if(idx == 0) {
			if(next == 1 || next == 2 || next == 5 || next == 6) return true;
		}
		//위에서 내려왔을 때
		else if(idx == 1) {
			if(next == 1 || next == 2 || next == 4 || next == 7) return true;
		}
		//오른쪽에서 왼쪽
		else if(idx == 2) {
			if(next == 1 || next == 3 || next == 4 || next == 5) return true;
		}
		//왼쪽에서 오른쪽
		else {
			if(next == 1 || next == 3 || next == 6 || next == 7) return true;
		}
		return false;
	}
}