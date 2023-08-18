import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 영식이 친구들
		int M = Integer.parseInt(st.nextToken());// 이 만치 받으면 아웃
		int L = Integer.parseInt(st.nextToken());// 번 째 사람

		int[] cnt = new int[N];// 누가 몇 번 받았는지 배열 크기는 N명

		int res = 0; // 출력할 결과
		int idx = 0;

		cnt[idx]++;// 1번 자리 앉은 사람은 무조건 공을 받고 시작함

		// 공을 던지자
		while (cnt[idx] < M) {// 받은게 M보다 작으면
			if (cnt[idx] % 2 == 1) {
				// 현재 공을 받은 횟수가 홀수
				// 시계방향 L번째 사람에게
				if(idx + L >= N) {
					idx = idx + L - N;// 나머지로 받음
					}
				else {
					idx = idx+L;
				}
				cnt[idx]++;// 공 받자마자 카운트
				res++;
				continue;
			} 
			else {// 현재 공을 받은 횟수가 짝수
				  // 반시계방향 L번째 사람에게
				if(idx - L < 0) {//인덱스에서 L을 뺏을 때 인덱스 표시가 곤란하다면
					idx = N - Math.abs(idx - L);// 나머지로 받음
					}
				else {// 뺄 수 있을 때
					idx = idx-L;
				}
				cnt[idx]++;// 공 받자마자 카운트
				res++;
				continue;
			}
		}		
	System.out.println(res);
	}
}