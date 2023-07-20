import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 1000;
		int S = 101;		
		
		//총 Test 횟수 입력 
		int num = sc.nextInt();

		for(int i = 0; i<num; i++) {
			int tc = sc.nextInt();//현재 testcase
			
			int[] std = new int [N];//학생 점수 1000개
			int[] scr = new int [S];//점수 빈도 배열 0점 부터 100점 101개
			
			int max = 0;//max값 초기화
			int cnt = 0;
			//학생 점수 배열 생성과 동시에 값을 인덱스로 점수 빈도 배열에 넣음
			for(int j = 0; j < N; j++) {
				std[j] = sc.nextInt();
				scr[std[j]] += 1;
				}
			//점수 빈도 배열에 카운트로 max 값 초기화
			for(int j = 0; j<S; j++) {
				if(cnt <= scr[j]) {
					cnt = scr[j];
					max = j;
				}
			}
			System.out.println("#" + tc + " " + max);	
		}
	}
}