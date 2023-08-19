import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean [] swich = new boolean [N+1];
		
		//스위치 배열 입력 완료
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
					
			if(num == 1) {
				swich[i+1] = !swich[i+1];
			}				
		}
		
		int rep = Integer.parseInt(br.readLine());//숫자 받는 횟수

		for(int i=0; i<rep; i++) {
			st = new StringTokenizer(br.readLine());

			int gender = Integer.parseInt(st.nextToken());//성별
			int num = Integer.parseInt(st.nextToken());//받은 숫자
			
			if(gender == 1) {// 남학생이면
				for(int j = 1; j<=N/num; j++) {//존재하는 배수만큼 반복
					swich[j*num] = !swich[j*num];
				}
			}
			
			if(gender == 2) {// 여학생이면
				swich[num] = !swich[num];//해당 스위치 바꿈
				int cnt = 0;
				
				for(int j = 1; j<=N/2; j++) {//양옆으로 늘어남	
					if(num+j<=N && num-j >=1 && swich[num+j] == swich[num-j]) {//조건 만족시
						cnt++;
					}
					else break;//아니면 탈출
				}
				
				for(int j=1;j<=cnt;j++) {
					swich[num+j] = !swich[num+j]; 
					swich[num-j] = !swich[num-j];
				}
			}
		}//스위치 만지기 종료
		
		for(int i=1; i<=N; i++) {
			if(swich[i]) {
				System.out.printf(1 + " ");
			}
			else {
				System.out.printf(0 + " ");
			}
			
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}
}