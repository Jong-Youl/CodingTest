import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int min = Integer.MAX_VALUE;
	public static boolean [] visit;
	public static int [][] scoreMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		scoreMap = new int [N+1][N+1];

		// 배열 입력
		for(int r = 1; r <=N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <=N; c++){
				scoreMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 1);

		System.out.println(min);
	}

	public static void comb(int depth, int idx) {
		if(depth == N/2) {
			int [] memberA = new int [N/2];
			int [] memberB = new int [N/2];
			int idxA = 0;
			int idxB = 0;
			int totalA = 0;
			int totalB = 0;

			for(int i = 1; i <= N; i++){
				if(visit[i]) {
					memberA[idxA++] = i;
				}
				else {
					memberB[idxB++] = i;
				}
			}

			for(int i = 0; i < N/2; i++){
				for(int j = 0; j < N/2; j++){
					if(i == j) continue;
					totalA += scoreMap[memberA[i]][memberA[j]];
					totalB += scoreMap[memberB[i]][memberB[j]];
				}
			}
			min = Math.min(min, Math.abs(totalA - totalB));
			return;
		}

		for(int i = idx; i <= N; i++) {
			if(visit[i]) continue;

			visit[i] = true;
			comb(depth + 1, i + 1);
			visit[i] = false;
		}
	}
}