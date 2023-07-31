import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		
		char [][] arr = new char[M][N];
		
		for(int r=0; r<M;r++) {//배열 입력
			String str = sc.next();
			for(int c=0; c<N;c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		for(int i=0; i<=M-8;i++) {//배열 입력
			for(int j=0; j<=N-8;j++) {
				int cnt = 0;
				for(int r=0; r<8;r++) {//보드와 체스판 크기 차이
					for(int c=0; c<8;c++) {
						int r_idx = r+i;
						int c_idx = c+j;
						
						if((r+c) % 2 == 0) {//r+c가 짝수이면 
							if(arr[r_idx][c_idx] == arr[i][j]) {//시작점과 같아야해요
							}
							else {//아니면 추가해 준답니다 ^^
								cnt++;
							}
						}
						else {//r+c가 홀수이면
							if(arr[r_idx][c_idx] != arr[i][j]) {//시작점과 달라야해요
							}
							else{//같다면 하나 추가요^^
								cnt++;
							}
						}
					}
				}
				//이전 cnt와 비교
				if(cnt > 32) {//8*8의 절반 32보다 작다면 cnt는 그대로
					min = Math.min(64-cnt, min);
				}
				else{
					min = Math.min(cnt, min);
				}
		
			}
		}
		System.out.println(min);
	}
}
