import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int n;
	static int m;
	static int finalCnt;
	static int cnt;
	static int[][] arr;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[n][m];
		visited = new boolean[n][m];
		Stack<Integer> stack = new Stack<>(); 

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		finalCnt = 0;
		cnt = 0;
		int max = 0; 

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (arr[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					finalCnt++;

					cnt++;
					dfs(r, c);
					
					max = Math.max(max, cnt); 
					stack.push(cnt); 
					
					cnt = 0;
				}
			}
		}
		System.out.println(finalCnt);
		System.out.println(max);
		
		
		int[] finalArr = new int[finalCnt]; 
		
		for(int i =0; i<finalCnt; i++) {
			finalArr[i] = stack.pop(); 
		}
	}

	private static void dfs(int r, int c) {

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
				if (arr[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					cnt++;

					dfs(nr, nc);
				}

			}
		}

	}
}
