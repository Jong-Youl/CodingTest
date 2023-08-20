import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 6;// 어떻게 참외밭이 6각형
		int cnt = Integer.parseInt(br.readLine());// 1M^2에 수확되는 참외수
		int square = 0;// 참외밭 면적
		int res = 0;

		int[] dist = new int[N];// 참외밭 길이

		int idx_x = 0;// 인덱스
		int idx_y = 0;// 인덱스
		
		int max_x = 0;// 값
		int max_y = 0;// 값

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			dist[i] = len;

			if (dir >= 3) {// 남:3 북:4이면 x임
				if (len == Math.max(max_x, len)) {// 지금 길이가 가장 길면
					max_x = len;
					idx_x = i;
				}
			} else {// 동 : 1, 서 : 2 면 y임
				if (len == Math.max(max_y, len)) {// 지금 길이가 가장 길면
					max_y = len;
					idx_y = i;
				}
			}
		}

		int min_x = 0;// 길이
		int min_y = 0;// 길이

		// 작은 직사각형 구하기
		// y
		if (idx_x == 0) {
			min_y = Math.abs(dist[1] - dist[N - 1]);
		} else if (idx_x == N - 1) {
			min_y = Math.abs(dist[N - 2] - dist[0]);
		} else {
			min_y = Math.abs(dist[idx_x + 1] - dist[idx_x - 1]);
		}
		// x
		if (idx_y == 0) {
			min_x = Math.abs(dist[1] - dist[N - 1]);
		} else if (idx_y == N - 1) {
			min_x = Math.abs(dist[N - 2] - dist[0]);
		} else {
			min_x = Math.abs(dist[idx_y + 1] - dist[idx_y - 1]);
		}

		square = max_x* max_y - min_x * min_y;
		res = square * cnt;

		System.out.println(res);
	}
}