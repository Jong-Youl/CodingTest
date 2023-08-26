import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int res;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 배열의 크기
		// 오른쪽 = 0
		// 대각선 = 1
		// 아래 = 2

		arr = new int[N + 1][N + 1];// 맵
		res = 0;
		// 맵 입력
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 완료
		
		pipe(0, 1, 2);

		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);
	}

	public static void pipe(int dir, int r, int c) {// 시뮬레이션
		if (r == N && c == N) {
			res++;
			return;
		}

		switch (dir) {// 현재 파이프 방향

		case 0:// 오른쪽으로 가야할 때
				// 오른쪽과 대각선 아래 가능
				// 근데 대각선 아래는 모두 가능
				// 그래서 오른쪽만 확인
			if (c + 1 <= N && arr[r][c + 1] == 0) {// 오른쪽이 막히지 않고 인덱스가 범위를 넘어가지 않는다면
				pipe(0, r, c + 1);
			}
			break;
		case 1:// 대각선
				// 오른쪽
			if (c + 1 <= N && arr[r][c + 1] == 0) {// 오른쪽이 막히지 않고 인덱스가 범위를 넘어가지 않는다면
				pipe(0, r, c + 1);
			}
			// 아래
			if (r + 1 <= N && arr[r + 1][c] == 0) {// 아래가 막히지 않고 인덱스가 범위를 넘어가지 않는다면
				pipe(2, r + 1, c);
			}
			break;

		case 2:// 아래
				// 아래
			if (r + 1 <= N && arr[r + 1][c] == 0) {// 아래가 막히지 않고 인덱스가 범위를 넘어가지 않는다면
				pipe(2, r + 1, c);
			}
			break;
		}
		// 모든 대각선의 경우
		if (r + 1 <= N && c + 1 <= N && arr[r + 1][c] == 0 && arr[r + 1][c + 1] == 0 && arr[r][c + 1] == 0) {
			pipe(1, r + 1, c + 1);
		}
	}
}