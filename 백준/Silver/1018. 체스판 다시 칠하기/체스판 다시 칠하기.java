import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N = 8;
	public static int total = 64;
	public static int min = Integer.MAX_VALUE;
	public static int R, C;
	public static char [][] map, A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char [R][C];
		A = new char [N][N];
		B = new char [N][N];

		for(int r = 0; r < N; r++){
			for(int c = 0; c < N; c++){
				if(c % 2 == r % 2) {
					A[r][c] = 'B';
				}
				else {
					A[r][c] = 'W';
				}
			}
		}

		for(int r = 0; r < R; r++){
			String str = br.readLine();
			for(int c = 0; c < C; c++){
				map[r][c] = str.charAt(c);
			}
		}


		for(int r = 0; r < R - 7; r++){
			for(int c = 0; c < C - 7; c++){
				min = Math.min(min, compare(r, c));
			}
		}

		System.out.println(min);
	}

	public static int compare(int r, int c) {
		int diff = 0;

		//A랑 비교
		for(int i = r; i < r + 8; i++) {
			for(int j = c; j < c + 8; j++) {
				if(map[i][j] != A[i-r][j-c]) diff++;
			}
		}

		return Math.min(diff, total - diff);
	}
}