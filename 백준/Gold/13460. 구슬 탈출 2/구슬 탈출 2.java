import java.io.*;
import java.util.*;

public class Main {
	
	public static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static int N, M, res;
	public static Pos red, blue, goal;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};	
	public static char [][] map;
	public static boolean [][][][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = 11;
		
		map = new char [N][M];
		visit = new boolean [N][M][N][M];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
				check(r, c);
			}
		}
		
		simulation();
		
		if(res > 10) sb.append(-1);
		else sb.append(res);
		
		System.out.println(sb);
	}
	
	private static void simulation() {
		Queue<int[]> q = new LinkedList<>();
		
		visit[red.r][red.c][blue.r][blue.c] = true;
		
		q.add(new int [] {red.r, red.c, blue.r, blue.c, 0});
		
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			int cnt = cur[4];
			
			if(cnt >= 10) {
				return;
			}
			
			for(int i = 0 ; i < 4; i++) {
				int r_nr = cur[0];
				int r_nc = cur[1];
				int b_nr = cur[2];
				int b_nc = cur[3];
				
				while(map[r_nr + dr[i]][r_nc + dc[i]] != '#') {
					r_nr += dr[i];
					r_nc += dc[i];
					
					if(map[r_nr][r_nc] == 'O') break;
				}
				
				while(map[b_nr + dr[i]][b_nc + dc[i]] != '#') {
					b_nr += dr[i];
					b_nc += dc[i];
					
					if(map[b_nr][b_nc] == 'O') break;
				}
				
				if(map[b_nr][b_nc] == 'O') {
					continue;
				}
				
				if(map[r_nr][r_nc] == 'O') {
					res = cnt + 1;
					return;
				}
				
				if(r_nr == b_nr && r_nc == b_nc && map[r_nr][r_nc] != 44) { 
					int r_move = Math.abs(r_nr-cur[0]) + Math.abs(r_nc-cur[1]);
					int b_move = Math.abs(b_nr-cur[2]) + Math.abs(b_nc-cur[3]);
					
					// 파란 공이 더 빨리 도착한 경우  
					if(r_move > b_move) {
						r_nr -= dr[i];
						r_nc -= dc[i];
					}else { // 빨간 공이 더 빨리 도착한 경우  
						b_nr -= dr[i];
						b_nc -= dc[i];
					}
				}
				
				if(!visit[r_nr][r_nc][b_nr][b_nc]) {
					visit[r_nr][r_nc][b_nr][b_nc] = true;
					q.add(new int[] {r_nr, r_nc, b_nr, b_nc, cnt+1});
				}
			}
		}
		
	}

	private static void check(int r, int c) {
		if(map[r][c] == 'R') {
			red = new Pos(r, c);
		}
		else if(map[r][c] == 'B') {
			blue = new Pos(r, c);
		}
		else if(map[r][c] == 'O') {
			goal = new Pos(r, c);
			return;
		}
		else {
			return;
		}
		map[r][c] = '.';
	}
}