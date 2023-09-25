
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int max;
	static int o;
	static int cnt; 
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2차원 배열 입력받기

		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}

		}

		// 0 1 2 3 4 5 6 7 8 max가 9 면

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > max) {
					max = map[i][j];
				}
			}
		}

		// 이 2차원 배열에서 제일 큰 수 찾기

		// 최대값을 넣을 배열
		int[] arr2 = new int[max];

		cnt = 0; // 안전영역의 개수

		// 1~최대높이 만큼 비가 오게 함
		for (o = 1; o <= max; o++) {
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (map[r][c] > o &&!visited[r][c] ) {
//						visited[r][c] = true; // 시작점 방문처리
						dfs(r, c);
						
						arr2[o - 1]++;
					}

				}
			}
			
//			System.out.println(Arrays.toString(arr2));
			
//			System.out.println(Arrays.deepToString(visited));

		}

//		System.out.println(Arrays.toString(arr2));

		int maxx = 1;

		for (int i = 0; i < arr2.length; i++) {
			if(arr2[i]>maxx) {
				
				maxx = arr2[i];
				
			}
		}
		
		System.out.println(maxx);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > o && !visited[nr][nc]) {
				dfs(nr, nc); // 시작점부터 탐색

			}
		}
	}

}
