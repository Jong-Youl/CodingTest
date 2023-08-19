import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] paper = new int[101][101];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int res = 0;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
						paper[r][c] = 1;
				}
			}
		}

		for (int r = 0; r < 101; r++) {
			for (int c = 0; c < 101; c++) {
				if (paper[r][c] == 1) {
					for (int i = 0; i < 4; i++) {
						int idx_r = r + dr[i];
						int idx_c = c + dc[i];
						
						if(check(idx_r, idx_c) && paper[idx_r][idx_c] == 0) {
							res++;
						}
					}
				}
			}
		}
		
		System.out.println(res);
	}

	public static boolean check(int r, int c) {
		return(r >=0 && r <= 101 && c >= 0 && c <= 101);
	}
}