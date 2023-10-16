import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// tc
		p: for (int tc = 1; tc <= T; tc++) {

			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n];

			// 특정 위치를 기준으로 그 지점까지의 최댓값을 넣을 2차원 배열
			int[][] max = new int[2][n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {

				arr[0][i] = Integer.parseInt(st.nextToken());

			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {

				arr[1][i] = Integer.parseInt(st2.nextToken());

			}

			if (n == 1) {

				System.out.println(Math.max(arr[0][0], arr[1][0]));
				continue;
			}

			max[0][0] = arr[0][0];
			max[1][0] = arr[1][0];
			max[0][1] = max[1][0] + arr[0][1];
			max[1][1] = max[0][0] + arr[1][1];

			for (int c = 2; c < n; c++) {
				for (int r = 0; r < 2; r++) {
					if (r == 0) {

						max[r][c] = Math.max(max[1][c - 2], max[1][c - 1]) + arr[r][c];
					}

					else {
						max[r][c] = Math.max(max[0][c - 2], max[0][c - 1]) + arr[r][c];

					}

				}
			}

			int finalMax = -1;

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {

					finalMax = Math.max(finalMax, max[i][j]);
				}

			}

			System.out.println(finalMax);

		} // tc

	}
}
