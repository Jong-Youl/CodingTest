import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] res = new int[N + 1];
		int[][] arr = new int[101][101];
		
		for (int i = 1; i <= N; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					int ny = y + r;
					int nx = x + c;
					arr[ny][nx] = i;
				}
			}
		}
		for (int r = 0; r < 101; r++) {
			for (int c = 0; c < 101; c++) {
				res[arr[r][c]]++;
			}
		}

		for (int idx = 1; idx <= N; idx++) {
			System.out.println(res[idx]);
		}

	}
}