import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static boolean [] num_check;
	public static int [] num;
	public static int [] Opt = new int [4];//사칙연산 횟수
	public static int result_max = Integer.MIN_VALUE; //결과 저장
	public static int result_min = Integer.MAX_VALUE; //결과 저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());//숫자 갯수
		
		num = new int[N];
		num_check = new boolean [N];
		Opt = new int[4];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {//숫자 배열 입력
			num[i] = Integer.parseInt(st.nextToken());
		}//입력완료
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4;i++) {//사칙연산 횟수 배열 입력
			Opt[i] = Integer.parseInt(st.nextToken());
		}//입력완료		
		
		Operator(num[0], 1);
		
		System.out.println(result_max);
		System.out.println(result_min);
	}
	
	public static void Operator(int res, int n) {
		//탈출
		if(n == N) {
			result_max = Math.max(result_max, res);//값과 비교
			result_min = Math.min(result_min, res);//값과 비교
			return;
		}
		
		for(int i=0;i<4;i++) {// 연산 횟수만큼 돌기
		
			if(Opt[i]>0) {//해당 연산 가능이면
				Opt[i]--;//연산 횟수 지워주고
			
				switch(i) {
					case 0: Operator(res + num[n], n+1);//다음 인덱스로 재귀
					break;
					case 1: Operator(res - num[n], n+1);//다음 인덱스로 재귀
					break;
					case 2: Operator(res * num[n], n+1);//다음 인덱스로 재귀
					break;
					case 3: Operator(res / num[n], n+1);//다음 인덱스로 재귀
					break;
				}
				//각 케이스 구하고 나면 배열 초기화 해줘야함
				Opt[i]++;//연산 횟수 채워주기
			}
			
		}
		
	}
}