import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		//무조건 5번을 돌림 -> 최대라서 어처피 돌려야함
		//끝나고 숫자를 셈
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int [][] map = new int [N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(N == 1)
			System.out.println(map[0][0]);
		else{
			simulation(0, map);
			System.out.println(max);
		}
	}

	public static void simulation(int reps, int [][] map) {
		if(reps == 5) {
			int tmp = 0;
			// 갯수 세는 메소드
			max = Math.max(max,count(map));
			return;
		}
		int [][] dummy = getDummy(map);
		//상하좌우

		int [][] up = up(dummy);
		dummy = getDummy(map);
		int [][] down = down(dummy);
		dummy = getDummy(map);
		int [][] left = left(dummy);
		dummy = getDummy(map);
		int [][] right = right(dummy);
		
		//다음턴
		simulation(reps + 1, up);
		simulation(reps + 1, down);
		simulation(reps + 1, left);
		simulation(reps + 1, right);
	}
	private static int [][] getDummy(int [][] map) {
		int [][] dummy = new int [N][N];

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				dummy[r][c] = map[r][c];
			}
		}
		return dummy;
	}
	private static int count(int[][] map) {
		int cnt = 0;

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				cnt = Math.max(cnt, map[r][c]);
			}
		}

		return cnt;
	}

	private static int[][] up(int[][] map) {
		//한 칸씩 돌아가면서
		for (int c = 0; c < N; c++) {
			int tmp = 0;
			for (int r = 1; r < N; r++) {
				if(map[r][c] == 0) continue;
				while (tmp < r) {
					//위에 칸이랑 같으면
					if (map[r][c] == map[tmp][c]) {
						map[tmp][c] += map[r][c];
						map[r][c] = 0;
						tmp++;
						break;
					} else if (map[tmp][c] == 0) {
						map[tmp][c] += map[r][c];
						map[r][c] = 0;
						break;
					} else {
						tmp++;
					}
				}
			}
		}
		return map;
	}

	private static int[][] down(int[][] map) {
		//한 칸씩 돌아가면서
		for (int c = 0; c < N; c++) {
			int tmp = N-1;
			for (int r = N - 2; r >= 0; r--) {
				if(map[r][c] == 0) continue;
				while (tmp > r) {
					//아래 칸이랑 같으면
					if (map[r][c] == map[tmp][c]) {
						map[tmp][c] += map[r][c];
						map[r][c] = 0;
						tmp--;
						break;
					} else if (map[tmp][c] == 0) {
						map[tmp][c] += map[r][c];
						map[r][c] = 0;
						break;
					} else {
						tmp--;
					}
				}
			}
		}
		return map;
	}

	private static int[][] left(int[][] map) {
		//한 칸씩 돌아가면서
		for (int r = 0; r < N; r++) {
			int tmp = 0;
			for (int c = 1; c < N; c++) {
				if(map[r][c] == 0) continue;
				while (tmp < c) {
					//왼쪽 칸이랑 같으면
					if (map[r][tmp] == map[r][c]) {
						map[r][tmp] += map[r][c];
						map[r][c] = 0;
						tmp++;
						break;
					} else if (map[r][tmp] == 0) {
						map[r][tmp] += map[r][c];
						map[r][c] = 0;
						break;
					} else {
						tmp++;
					}
				}
			}
		}
		return map;
	}

	private static int[][] right(int[][] map) {
		//한 칸씩 돌아가면서
		for (int r = 0; r < N; r++) {
			int tmp = N-1;
			for (int c = N-2; c >= 0; c--) {
				if(map[r][c] == 0) continue;
				while (tmp > c) {
					//오른쪽 칸이랑 같으면
					if (map[r][c] == map[r][tmp]) {
						map[r][tmp] += map[r][c];
						map[r][c] = 0;
						tmp--;
						break;
					} else if (map[r][tmp] == 0) {
						map[r][tmp] += map[r][c];
						map[r][c] = 0;
						break;
					} else {
						tmp--;
					}
				}
			}
		}
		return map;
	}
}