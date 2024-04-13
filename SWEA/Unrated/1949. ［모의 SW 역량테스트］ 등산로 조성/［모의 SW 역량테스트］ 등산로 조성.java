import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N, K, max;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	public static int [][] map;
	//한 번만 깎을 수 있음
	public static boolean [][] visit;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			map = new int [N][N];
			visit = new boolean[N][N];

			int height = 0;
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(height < map[r][c]) {
						height = map[r][c];
					}
				}
			}

			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(height == map[r][c]){
						visit = new boolean[N][N];
						visit[r][c] = true;
						dfs(r, c, 0, map[r][c], 1);
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	//횟수, 길이
	public static void dfs (int r, int c, int cnt, int value, int length) {
		if(length > max)
			max = length;

		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//인덱스 확인
			if(0 <= nr && nr < N && nc >= 0 && nc < N) {
				//방문처리 확인
				if(!visit[nr][nc]) {
					// 갈 수 있는지 확인
					if(map[nr][nc] >= value) {
						// 갈 수 없으면 깎아서 갈 수 있는지 확인
						if (cnt == 0) {
							// 2
							if (map[nr][nc] - K < value) {
								visit[nr][nc] = true;
								dfs(nr, nc, cnt + 1, value - 1, length + 1);
								visit[nr][nc] = false;
							}
						}
					}
					//갈 수 있으면 그냥 가셈
					else {
						visit[nr][nc] = true;
						dfs(nr, nc, cnt, map[nr][nc], length + 1);
						visit[nr][nc] = false;
					}
				}
			}
		}
	}
}