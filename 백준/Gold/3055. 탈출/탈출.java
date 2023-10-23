import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Pos{
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	
	public static Pos start;
	public static int N, M, res;
	public static char [][] map;
	public static boolean [][] visit;
	
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());//R
		M = Integer.parseInt(st.nextToken());//C
		map = new char [N][M];
		visit = new boolean [N][M];
		
		res = 0;
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < M; c++) {
				map [r][c] = str.charAt(c);
				if(map [r][c] == 'S' || map [r][c] == 'X' || map [r][c] == '*') visit[r][c] = true;
				if(map [r][c] == 'S') start = new Pos(r, c, 0);
			}
		}
		
		//'.' 평지, '*' 물, 'X' 돌, 'D' 비버의 굴, 'S' 고슴도치의 위치
		block();
		simulation();

		if(res == 0) {
			sb.append("KAKTUS");
		}
		else {
			sb.append(res);
		}
		
		System.out.println(sb);
	}

	private static void block() {
		//물의 주변을 미리 바꿔줌
		List<Pos> tmp = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == '*') {
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						//평지일때만 물에 잠길 수 있음
						if(check(nr, nc) && map[nr][nc] == '.') tmp.add(new Pos(nr, nc, 0));
					}
				}
			}
		}
		
		for(int i = 0; i < tmp.size(); i++) {
			int tmp_r = tmp.get(i).r;
			int tmp_c = tmp.get(i).c;
			
			map[tmp_r][tmp_c] = '*';
			visit[tmp_r][tmp_c] = true;
		}
	}

	private static void simulation() {
		// 한 턴에 물 주변에 하나씩 추가 따로 처리 없이 추가? 
		Queue<Pos> q = new LinkedList<>();
		
		q.add(start);
		
		// 시작은 0분
		int minute = 0;
		
	p:	while (!q.isEmpty()) {
			//find가 true이거나 q가 비어있으면 탈출
			Pos cur = q.poll();
			
			if(cur.cnt > minute) {
				minute++;
				block();
			}
			
			for(int i = 0; i < 4; i++) {
				
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				Pos tmp = new Pos(nr, nc, cur.cnt + 1);
				//이미 존재하지 않으면서, index가 펑크나지 않는 경우
				if(check(nr, nc) && !visit[nr][nc] && !q.contains(tmp)) {
					q.add(tmp);
					visit[nr][nc] = true;
					//해당칸이 S이면 
					if(map[nr][nc] == 'D') {
						res = tmp.cnt;
						break p;
					}
				}
			}
		}
		
		
	}

	private static boolean check(int r, int c) {
		if(0 <= r && 0 <= c && r < N && c < M && !visit[r][c]) return true;
		
		return false;
	}
	
	

}