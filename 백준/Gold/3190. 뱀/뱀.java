import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int [][] map;
	public static int time, N, C;
	public static List<int[]> snake, commend;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1]= 1;
		}

		C = Integer.parseInt(br.readLine());
		commend = new ArrayList<>();

		for(int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int cmd = st.nextToken().equals("D")? 0: 1;
			commend.add(new int[] {t, cmd});
		}

		snake = new LinkedList<>();
		snake.add(new int []{0, 0});
		simulation();

		System.out.println(time);
	}

	public static void simulation() {
		//시작 방향은 상 우 하 좌
		int dir = 1;
		int idx = 0;
		int r = 0;
		int c = 0;

		while (true) {
			if (C > idx && commend.get(idx)[0] == time) {
				if (commend.get(idx)[1] == 0) {
					dir++;
					if (dir == 4) dir = 0;
				}
				else {
					dir--;
					if (dir == -1) dir = 3;
				}
				idx++;
			}
			time++;
			//상
			if(dir == 0) {
				r--;
				if( r < 0 || isSnake(r, c)) {
					return;
				}
				snake.add(new int []{r, c});
				if (map[r][c] == 0) {
					snake.remove(0);
				}
				else map[r][c] = 0;
			}
			//우
			else if(dir == 1) {
				if(c > N-2 || isSnake(r, c + 1)) {
					return;
				}
				c++;
				snake.add(new int []{r, c});
				// System.out.print("before : " + map[r][c] + " time : " + time);
				if (map[r][c] == 0) {
					snake.remove(0);
				}
				else map[r][c] = 0;
				// System.out.println(" after : " + map[r][c] + " time : " + time);
			}
			//하
			else if(dir == 2) {
				if(r > N-2 || isSnake(r+1, c)) {
					return;
				}
				r++;
				snake.add(new int []{r, c});
				if (map[r][c] == 0) {
					snake.remove(0);
				}
				else map[r][c] = 0;
			}
			//좌
			else {
				if( c < 1 || isSnake(r, c - 1)) {
					return;
				}
				c--;
				snake.add(new int []{r, c});
				if (map[r][c] == 0) {
					snake.remove(0);
				}
				else map[r][c] = 0;
			}
		}

	}

	public static boolean isSnake(int r, int c) {
		for (int[] tmp : snake) {
			if (tmp[0] == r && tmp[1] == c) {
				return true;
			}
		}
		return false;
	}
}