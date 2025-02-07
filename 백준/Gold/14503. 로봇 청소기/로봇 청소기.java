import java.io.*;
import java.util.*;

/*
 * 배열
 *  1인 경우 = 벽
 * 	0인 경우 = 청소되지 않은 빈칸
 *  -1인 경우 = 청소된 빈 칸
 *  
 * 동작
 * 1. 현재칸이 청소 안된 경우 가장 먼저 청소
 * 2. 상하좌우 탐색
 * 3. 상하좌우 중 청소되지 않은 빈 칸이 없는 경우
 * 	3-1. 바라보는 방향을 유지한 채로 한칸 후진할 수 있다면 후진
 * 	3-2. 바라보는 방향의 뒤쪽칸이 벽이라 후진할 수 없다면 작동을 멈춤
 * 4. 주변에 청소되지 않은 칸이 있는 경우
 * 	4-1. 반시계 방향으로 90도 회전
 * 	4-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
 * */		

public class Main {
	// 북 -> 동 -> 남 -> 서
	private static int [] dr = {-1, 0, 1, 0};
	private static int [] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int currR = Integer.parseInt(st.nextToken());
		int currC = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int [][] map = new int [N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		// init
		
		// simulation -> bfs
		Queue<int []> q = new LinkedList<>();
		q.add(new int [] {currR, currC});
		
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			//1. 현재칸이 청소 안된 경우 가장 먼저 청소
			if(map[r][c] == 0) {
				cnt++;
				map[r][c] = -1;
			}
			
			boolean isValid = false;
			//2. 주변 칸에 청소가 안된 곳이 있는지 확인
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// checkIndex
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				// checkIndex
				
				if(map[nr][nc] == 0) {
					isValid = true;
					break;
				}
			}
			
			// 3. 주변에 청소되지 않은 칸이 없는 경우
			if(!isValid) {
				int nr = r + dr[(dir + 2) % 4];
				int nc = c + dc[(dir + 2) % 4];
				// 3-1. 바라보는 방향을 유지한 채로 한칸 후진할 수 있다면 후진
				// checkIndex
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
					q.add(new int [] {nr, nc});
				}
				// checkIndex
				// 3-2. 바라보는 방향의 뒤쪽칸이 벽이라 후진할 수 없다면 작동을 멈춤
				else {
					break;					
				}
			}
			
			// 4. 주변에 청소되지 않은 칸이 있는 경우
			else {
				while(true) {
					// 4-1. 반시계 방향으로 90도 회전
					dir--;
					if(dir < 0) dir = 3;
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					// 4-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
					// checkIndex
					if(nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					// checkIndex
					if(map[nr][nc] == 0) {
						q.add(new int [] {nr, nc});
						break;
					}
				}
			}
			
		}
		//bfs
		
		System.out.println(cnt);
	}
}