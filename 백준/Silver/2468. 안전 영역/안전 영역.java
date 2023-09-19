import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;
	public static int cnt, max, N;
	public static int[][] map;
	public static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		max = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int deep = 0;// 수심

		cnt = -1;

		while (cnt != 0) {// 어처피 물 차오를수록 더 많이 갈라짐
			cnt = 0;
			find(deep);
			visit = new boolean[N][N];
			max = Math.max(max, cnt);
			deep++;
			
		}

		System.out.println(max);

	}

	public static void find(int deep) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] <= deep) {// 잠겨야겠지?
					visit[r][c] = true;// 히히 못가
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visit[r][c]) {
					cnt++;
					visit[r][c] = true;
					check(r, c);
				}
			}
		}
	}

	public static void check(int r, int c) {
		//상하좌우
		//상
		if(r-1 >= 0 && !visit[r-1][c]) {//인덱스가 범위 안에 존재하고 방문한적이 없다면
			visit[r-1][c] = true;
			check(r-1, c);
		}
		//하
		if(r+1 < N && !visit[r+1][c]) {//인덱스가 범위 안에 존재하고 방문한적이 없다면
			visit[r+1][c] = true;
			check(r+1, c);
		}
		//좌
		if(c-1 >= 0 && !visit[r][c-1]) {//인덱스가 범위 안에 존재하고 방문한적이 없다면
			visit[r][c-1] = true;
			check(r, c-1);
		}
		//우
		if(c+1 < N && !visit[r][c+1]) {//인덱스가 범위 안에 존재하고 방문한적이 없다면
			visit[r][c+1] = true;
			check(r, c+1);
		}
	}
}