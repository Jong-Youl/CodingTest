import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static int N, max;
	//시계방향 대각선 -> 우상, 우하, 좌하, 좌상
	public static int [] dr = {-1, 1, 1, -1};
	public static int [] dc = {1, 1, -1, -1};
	public static int [][] map;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			map = new int [N][N];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					List <Integer> menu = new ArrayList<>();
					find(r, c, r, c, 0, 0, menu);
				}
			}

			if(max == Integer.MIN_VALUE) {
				sb.append(-1).append("\n");
			}
			else sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	//dfs로 해야함
	public static void find (int startR, int startC, int r, int c, int cnt, int dir, List<Integer> menu) {
		if(startR == r && startC == c && dir == 3) {
			max = Math.max(max, cnt);
			return;
		}

		List<Integer> dummy = new ArrayList<>();
		dummy.addAll(menu);

		if(dummy.contains(map[r][c])) return;
		dummy.add(map[r][c]);

		if(0 <= r + dr[dir] && r + dr[dir] < N && 0 <= c + dc[dir] && c + dc[dir] < N){
			find(startR, startC, r+dr[dir], c + dc[dir], cnt+1, dir, dummy);
		}
		if(dir < 3) {
			if(0 <= r + dr[dir + 1] && r + dr[dir + 1] < N && 0 <= c + dc[dir + 1] && c + dc[dir + 1] < N){
				find(startR, startC, r+dr[dir + 1], c + dc[dir + 1], cnt+1, dir + 1, dummy);
			}
		}
	}
}