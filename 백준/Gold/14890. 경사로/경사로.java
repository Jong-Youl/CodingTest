import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}

		// check
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (checkRow(map, i, L))
				cnt++;
			if (checkCol(map, i, L))
				cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean checkRow(int[][] map, int idx, int L) {
		boolean[] visit = new boolean[map.length];

		for (int i = 0; i < map.length - 1; i++) {
			int diff = Math.abs(map[idx][i] - map[idx][i + 1]);
			
			if(diff > 1)
				return false;
			else {
				if(map[idx][i] - map[idx][i + 1] == 1) {
					// 앞에 경사로 내릴 수 있는지 확인
					for(int j = 1; j <= L; j++) {
	                    if(i + j >= map.length || visit[i + j]) 
	                    	return false;
	                    if(map[idx][i + 1] != map[idx][i + j]) 
	                    	return false;
	                    visit[i + j] = true;
	                }
				}
				else if(map[idx][i] - map[idx][i + 1] == -1) {
					// 뒤에 경사로 내릴 수 있는지 확인
					for(int j = 0; j < L; j++) {
	                    if(i - j < 0 || visit[i - j]) 
	                    	return false;
	                    if(map[idx][i] != map[idx][i - j]) 
	                    	return false;
	                    visit[i - j] = true;
	                }
				}
			}
		}
		return true;
	}
	
	private static boolean checkCol(int[][] map, int idx, int L) {
		boolean[] visit = new boolean[map.length];
		
		for (int i = 0; i < map.length - 1; i++) {
			int diff = Math.abs(map[i][idx] - map[i + 1][idx]);
			
			if(diff > 1)
				return false;
			else {
				if(map[i][idx] - map[i + 1][idx] == 1) {
					// 앞에 경사로 내릴 수 있는지 확인
					for(int j = 1; j <= L; j++) {
						if(i + j >= map.length || visit[i + j]) 
							return false;
						if(map[i + 1][idx] != map[i + j][idx]) 
							return false;
						visit[i + j] = true;
					}
				}
				else if(map[i][idx] - map[i + 1][idx] == -1) {
					// 뒤에 경사로 내릴 수 있는지 확인
					for(int j = 0; j < L; j++) {
						if(i - j < 0 || visit[i - j]) 
							return false;
						if(map[i][idx] != map[i - j][idx]) 
							return false;
						visit[i - j]  = true;
					}
				}
			}
		}
		return true;
	}
}