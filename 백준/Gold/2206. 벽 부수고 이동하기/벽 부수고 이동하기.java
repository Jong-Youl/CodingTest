import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited; // !!!
	
	static int minLen;
	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		map = new int[N+1][M+1]; // 1 ~ N, 1 ~ M 사용하기 위해
		visited = new boolean[N+1][M+1][2]; // !!!
		
		// 2차원 배열 입력 받기
		for(int r=1; r<=N; r++) {
			String str = sc.next();
			for(int c=1; c<=M; c++) {
				map[r][c] = str.charAt(c-1) - '0';
			}
		}
		
		minLen = Integer.MAX_VALUE;
		// (1, 1) => (N, M) 최단 경로
		bfs(1, 1);
		if(minLen == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minLen);
		
		
	}


	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[row][col][0] = true;
					// 행 좌표, 열 좌표, 벽 부순 횟수, 거리
		q.offer(new int[] {row, col, 0, 1});
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			
			int r = v[0];
			int c = v[1];
			int cnt = v[2];
			int len = v[3];
			
			if(r == N && c == M) { 
				if(len < minLen) minLen = len;
			}
			
			// cnt == 0 vs. cnt == 1
			// 1. cnt== 0 이라면
			// 		벽을 부수는 경우도 고려 가능하고
			// 2. cnt == 1이라면
			//      벽이 아닌 곳으로만 이동.
			
			// (r, c)를 기준으로 인접 정점 탐색
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// (nr, nc) 일단 2차원 배열 안에 있고(경계조건)
				// 아직 방문하지 않은 정점이면 
				// 큐에 넣는다.
				
				if(nr >= 1 && nr <= N && nc >=1 && nc <= M) {
					if(map[nr][nc] == 0 && !visited[nr][nc][cnt]) {
						visited[nr][nc][cnt] = true;
						q.offer(new int[] {nr, nc, cnt, len+1});
					}
					
					if(map[nr][nc] == 1 && cnt == 0 && !visited[nr][nc][cnt+1]) {
						visited[nr][nc][cnt+1] = true;
						q.offer(new int[] {nr, nc, cnt+1, len+1});
					}
				}
			}
		}
	}

}