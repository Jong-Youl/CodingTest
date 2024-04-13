import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// N은 최대 20, M은 최대 10
	public static int N, M, homeCnt, max;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0, 0, -1, 1};
	public static int [] cost = new int [46];
	public static int [][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int i = 1; i <= 45; i++) {
			cost[i] = (i * i) + (i-1) * (i-1);
		}

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			//도시의 크기, 하나의 집이 지불할 수 있는 비용 M
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = 0;
			homeCnt = 0;
			map = new int [N][N];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) homeCnt++;
				}
			}
			simulation();
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

	public static void simulation() {
		int limit = homeCnt * M;
		int k = 0;
		for(int i = 1; i <= 45; i++) {
			if(cost[i] >= limit) {
				k = i;
				break;
			}
		}
		while(k > 0) {
			checkTown(k);
			k--;
		}
	}

	private static void checkTown(int k) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int dist = 0;
				int houseCount = 0;
				for(int i=r-(k-1); i<r+k; i++) {
					for(int j=c-dist; j<=c+dist; j++) {
						if(i<0 || i >= map.length || j<0 || j>= map.length) continue;
						if(map[i][j] == 1) {
							houseCount++;
						}
					}

					if(i < r) {
						dist++;
					}
					else {
						dist--;
					}
				}

				if(houseCount * M >= cost[k] && max < houseCount) {
					max = houseCount;
				}
			}
		}
	}
}