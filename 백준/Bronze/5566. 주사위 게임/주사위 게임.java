import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int pos = 0;
		int total = 0;

		//보드 정보
		int [] board = new int [N];
		for(int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		//주사위 정보
		int [] dice = new int [M];
		for(int i = 0; i < M; i++) {
			dice[i] = Integer.parseInt(br.readLine());
		}

		while (pos < N - 1) {
			for(int tmp : dice) {
				//주사위 굴리기
				pos += tmp;
				total++;
				if(pos >= N-1) break;

				//보드 효과 적용
				if(board[pos] != 0) {
					pos += board[pos];
				}
				
				//현재 위치 확인
				if(pos >= N-1) break;
			}
		}
		//출력
		System.out.println(total);
	}
}