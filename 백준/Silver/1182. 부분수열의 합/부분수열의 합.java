import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;//정수의 갯수
	static int S;//목표 합
	static boolean [] visit ;//방문확인
	static int [] arr;//숫자를 담을 배열
	static int cnt;//경우의 수 카운트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//정수의 갯수
		S = Integer.parseInt(st.nextToken());//목표 합 
		
		// 수 배열, 방문확인 배열 생성
		visit = new boolean [N];
		arr = new int[N];
		int sum = 0;
		// 수 배열 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}// 수 배열 입력 완료
	
		sumation(0, 0);
		
		if(S==0) {//sum 입력 값이 0이기 때문에 시작부터 카운트 방지
			cnt -= 1;
		}
		if(sum == S) {
			cnt += 1;
		}
		
		System.out.println(cnt);
		
	}
	
	public static void sumation(int sum, int depth) {
		if(depth == N) {
			return;
		}
		
		if(sum == S) {//정수의 누적합이 sum이랑 같아지면
			cnt++;//카운트를 늘려준다.
		}
		
		
		for(int i=depth; i<N; i++) {
			if(!visit[i]) {//더 한적 없는 수라면
				visit[i] = true;
				sumation(sum+arr[i], depth+1);//더한 값을 sum argument로 사용
				for(int j = i+1; j<N; j++) {//본인 인덱스 이상의 인덱스 false처리
					visit[j] = false;
				}
			}
		}
	}
}