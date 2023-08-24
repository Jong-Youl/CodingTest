import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int[] dr = { 0, 1 };// 오른쪽, 아래
		int[] dc = { 1, 0 };// 오른쪽, 아래

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());// 배열 크기
			int K = Integer.parseInt(st.nextToken());// 단어 길이
			int res = 0;

			int[][] arr = new int[N][N];

			// 배열 입력
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			} // 완료
			
			// 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 1) {// 흰색칸일 떄
					p:	for (int i = 0; i < 2; i++) {
							int pr = r - dr[i];// 시작 이전 값
							int pc = c - dc[i];// 시작 이전 값
							
							// 이전의 값이 존재하면서 그게 1이면
							if (pr >= 0 && pc >= 0 && arr[pr][pc] == 1) {
								continue;//다음방향 탐색
							}
							
							int cnt = 0;
							
							for (int j = 0; j < K; j++) {
								
								int nr = r + j * dr[i];
								int nc = c + j * dc[i];
								// 인덱스에 오류가 없고 값이 계속 1이라면
								if (nr < N && nr >= 0 && nc < N && nc >= 0 && arr[nr][nc] == 1) {
									cnt++;
								} else {// 인덱스가 막히거나 1이 아니라면
									continue p;// 현 방향 탐색 종료
								}
								// 탈출했다면 cnt = k상태임
								// 앞이 1인지 확인해야함
								if(cnt == K) {//다 돌았을 때
									nr += dr[i];
									nc += dc[i];
									if (nr < N && nc < N && arr[nr][nc] == 1) {// 앞이 존재하면서 앞이 1이면
										break;
									} else {// 값이 존재하지 않거나 0이라면
										res++;
										
									}
								}
							}

						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
