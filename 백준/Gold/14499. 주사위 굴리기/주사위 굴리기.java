import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//처음에 모든 면이 0
		//칸에 올라감
		//0일 때 주사위 바닥면에 쓴 수가 지도에 박히고 주사위 바닥면은 0이 됨
		//숫자일 때 반대
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] map = new int [N][M];
		//주사위 시작 위치
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		//명령 수
		int K = Integer.parseInt(st.nextToken());
		Queue <Integer> cmd = new LinkedList<>();
		//지도 채우기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//명령 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			cmd.add(Integer.parseInt(st.nextToken()));
		}
		//처음엔 모두 0
		int [] dice = new int [7];
		/*
		*    1
		* 2  3  4
		*    5
		*    6
		*
		* 위로 갈 때는 1 3 5 6, 옆으로 구를 때는 2 3 4 6
		*
		* */
		while(!cmd.isEmpty()) {
			int dir = cmd.poll();
			//동 서 북 남
			if(dir == 1) {
				if(c > M - 2) continue;

				int tmp = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[4];
				dice[4] = dice[3];
				dice[3] = tmp;

				if(map[r][++c] == 0) {
					map[r][c] = dice[6];
				}
				else {
					dice[6] = map[r][c];
					map[r][c] = 0;
				}
			}
			else if(dir == 2) {
				if(c < 1) continue;

				int tmp = dice[6];
				dice[6] = dice[2];
				dice[2] = dice[3];
				dice[3] = dice[4];
				dice[4] = tmp;

				if(map[r][--c] == 0) {
					map[r][c] = dice[6];
				}
				else {
					dice[6] = map[r][c];
					map[r][c] = 0;
				}
			}
			else if(dir == 3) {
				if(r < 1) continue;

				int tmp = dice[1];
				dice[1] = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;

				if(map[--r][c] == 0) {
					map[r][c] = dice[6];
				}
				else {
					dice[6] = map[r][c];
					map[r][c] = 0;
				}
			}
			else {
				if(r > N - 2) continue;

				int tmp = dice[6];
				dice[6] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[5];
				dice[5] = tmp;

				if(map[++r][c] == 0) {
					map[r][c] = dice[6];
				}
				else {
					dice[6] = map[r][c];
					map[r][c] = 0;
				}
			}
			System.out.println(dice[3]);
		}
	}
}