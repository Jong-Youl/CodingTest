import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[] visit;	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		arr = new int[N][N];
		visit = new boolean[N];
 
 
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
 
		start_link(0, 0);
		System.out.println(min);
 
	}
	static void start_link(int idx, int depth) {
		if(depth == N / 2) {//depth가 최대로 채워지면
			score();//점수 반환
			return;//종료
		}
 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;	// 방문 체크
				start_link(i + 1, depth + 1);// 재귀
                visit[i] = false;
			}
		}
	}
 
	static void score() {
		int start_score = 0;
		int link_score = 0;
        int diff = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) { 
				if (visit[i] == true && visit[j] == true) {//둘 다 true면 start팀
					start_score += arr[i][j];
					start_score += arr[j][i];
				}
				else if (visit[i] == false && visit[j] == false){//둘 다 false면 false 팀
					link_score += arr[i][j];
					link_score += arr[j][i];
				}
			}
		}
		// 두 팀의 점수 차이
		diff = Math.abs(start_score - link_score);
		min = Math.min(diff, min);
				
	}
 
}