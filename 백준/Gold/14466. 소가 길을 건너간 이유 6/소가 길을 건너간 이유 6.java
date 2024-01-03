import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static boolean visit[][][][],check[][];
	public static int N, K, R, result;
	public static int dr[]= {-1, 1, 0, 0};
	public static int dc[]= {0, 0, -1, 1};
	public static Pos pos[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1][N + 1][N + 1][N + 1];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			visit[x1][y1][x2][y2] = true;
			visit[x2][y2][x1][y1] = true;
		}
		
		pos = new Pos[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pos[i] = new Pos(r, c);
		}
		
		for (int i = 0; i < K; i++) {
			check = new boolean[N + 1][N + 1];
			bfs(pos[i].r, pos[i].c);
			
			//나머지 소들의 위치가 방문처리 됐다면 추가
			for (int j = i + 1; j < K; j++) {
				if (!check[pos[j].r][pos[j].c]) {
					result++;
				}
			}
		}
		System.out.println(result);

	}
	private static void bfs(int r, int c) {
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(r,c));
		
		check[r][c]=true;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr =tmp.r + dr[i];
				int nc=tmp.c + dc[i];
				if(nr <=0 || nr >N || nc <=0 || nc > N)
					continue;
				//이전 위치에서 현재 위치에 오는게 
				if(visit[tmp.r][tmp.c][nr][nc]||check[nr][nc])
					continue;
				
				//현재 도착한 정점 방문처리
				check[nr][nc]=true;
				q.add(new Pos(nr, nc));
			}
		}
		
	}

}