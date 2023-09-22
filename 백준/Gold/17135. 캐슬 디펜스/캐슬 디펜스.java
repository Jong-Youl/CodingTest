import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static class Pos {
		int r, c;

		public Pos() {
		}

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}

	public static StringTokenizer st;
	public static int N, M, D, max;
	public static int [][] map, copy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 행
		M = Integer.parseInt(st.nextToken());// 열
		D = Integer.parseInt(st.nextToken());// 사거리

		map = new int[N][M];// 게임 맵
		copy = new int[N][M];// 복구 할 맵
		max = 0;
		
		// 게임 맵 정보받기
		// 복사용도 한번에
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				copy[r][c] = map[r][c];
			}
		}
		
		if(M <= 3) {//3칸까지는 모두 잡을 수 있음
			for(int r = 0 ; r < N; r++) {
				for(int c = 0 ; c < M; c++) {
					max += map[r][c];
				}
			}
		}
		
		else {
			position();
		}
		
		System.out.println(max);
	}

	public static void position() {// 궁수 위치 조정
		// 위치 조정 후 바로 한 번의 게임을 시작
		// 넘겨줄 궁수 열 위치
		int[] archer = new int[3];
		
		for (int i = 0; i < M - 2; i++) {
			archer[0] = i;
			for (int j = i + 1; j < M - 1; j++) {
				archer[1] = j;
				for (int k = j + 1; k < M; k++) {
					archer[2] = k;
					attack(archer);
					backUp();
				}
			}
		}	
	}
	
	public static void backUp() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = copy[r][c];
			}
		}
	}
	
	public static void upDate() {
		//한칸씩 밀고
		for(int r = N-1; r > 0; r--) {
			for(int c = 0; c < M; c++) {
				map[r][c] = map[r-1][c];
			}
		}
		//첫 줄은 0으로 채움
		for(int c = 0; c < M; c++) {
			map[0][c] = 0;
		}
	}
	
	public static void attack(int[] archer) {
		// 궁수의 공격(인자는 각 궁수의 열)
		// 각 궁수의 위치에서 한 턴에 한 번 쏠 수 있음 D이하의 거리에 가장 가까운 적을 죽임
		// 동시에 같은 표적 죽이기 가능
		int stage = 1;
		int cnt = 0;

		while(stage <= N) {
			//레이드 1 to N 모든 행을 다 받을 때 까지
			
			//표적을 담을 배열 더미 값으로 미리 채워줌
			//오류방지
			Pos[] target = new Pos[archer.length];
			
			for(int i = 0; i < archer.length; i++) {
				target[i] = new Pos(16, 16);
			}
			// 매 궁수마다의 공격을 표현
		p:	for (int i = 0; i < archer.length; i++) {
				// dist => 사거리// 사거리까지 시행 1만큼 찾고 
				int dist = 0;
				while (dist < D && target[i].r == 16) {// 뽑거나 사거리를 넘기면 종료
					//표적의 위치
					//제일 왼쪽부터 찾아야 하기 때문에 아처의 바로 위 칸부터 탐색
					int nr = N - 1;
					int nc = archer[i] - dist;

					while (nc <= archer[i] + dist && target[i].c > nc) {// 오른쪽 거리 dist 넘어가면 접음
						// 범위를 만족하고 적이 있다면
						if (check(nr, nc) && map[nr][nc] == 1) { 
							//기존의 표적보다 왼쪽에 있을 경우
							//그 표적으로 바꿈
							if(target[i].c > nc) {
								target[i].r = nr;
								target[i].c = nc;
							}
						}
						if (nc >= archer[i]) // 정면 일직선에 오면 내려감
							nr += 1;
						else // 정면 일직선상에 오기 전에는 올라감
							nr -= 1;
						nc++;
					}
					dist++;
				}
			}
			// 스테이지 끝나고 정리
			for(int i = 0; i < target.length; i++) {
				
				//어처피 지워질 칸이 아니면 적이 죽었으니까 1 -> 0으로
					int r = target[i].r;
					int c = target[i].c;
					
//					System.out.println("r : " + r + " c: " + c);
					
					if(r == 16) continue;
					
					if (map[r][c] == 1) {//1이면 탈출
						map[r][c] = 0;
						cnt++;
					}
			}
			upDate();
			
			stage++;
		}
		//스테이지가 종료되면 총합이 죽인 적의 수임
		max = Math.max(max, cnt);
	}

	private static boolean check(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M) return true;
		return false;
	}

}