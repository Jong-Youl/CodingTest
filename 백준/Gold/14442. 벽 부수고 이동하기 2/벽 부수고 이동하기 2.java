import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M, K;	
	private static int [] dr = {-1, 1, 0, 0};
	private static int [] dc = {0, 0, -1, 1};
	private static int [][] map;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		int result = bfs();
		
		System.out.println(result);
	}
	
	private static int bfs() {
		int result = -1;
		Queue<Pos> q = new LinkedList<>();
		boolean [][][] visit = new boolean [N][M][K + 1];
		q.add(new Pos(0, 0, 0, 1));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			if(tmp.r == N - 1 && tmp.c == M - 1) {
				result = tmp.dist;
				break;
			}
			
			for(int i = 0; i < dr.length; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				
				if(checkIndex(nr, nc)) {
					if(map[nr][nc] == 0) {
						if(!visit[nr][nc][tmp.cnt]) {
							q.add(new Pos(nr, nc, tmp.cnt, tmp.dist + 1));
							visit[nr][nc][tmp.cnt] = true;							
						}
					}
					else {
						if(tmp.cnt < K && !visit[nr][nc][tmp.cnt + 1]) {
							q.add(new Pos(nr, nc, tmp.cnt + 1, tmp.dist + 1));
							visit[nr][nc][tmp.cnt + 1] = true;
						}
					}
				}
			}
		}
		return result;
	}

	private static boolean checkIndex(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static class Pos{
		int r, c, cnt, dist;
		
		public Pos(int r, int c, int cnt) {
			this.r= r;
			this.c= c;
			this.cnt= cnt;
			this.dist = 0;
		}
		
		public Pos(int r, int c, int cnt, int dist) {
			this.r= r;
			this.c= c;
			this.cnt= cnt;
			this.dist = dist;
		}
	}
}