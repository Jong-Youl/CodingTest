import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 5;
	static boolean [][] check = new boolean[N][N];
	static int [][] bingo = new int[N][N];
	static int res = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int r = 0; r< N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c<N; c++) {
				bingo[r][c] = Integer.parseInt(st.nextToken());
			}
		}//철수 빙고 입력
		
		
		
	p:	for(int r = 0; r< N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c< N; c++) {
				int num = Integer.parseInt(st.nextToken());
				res++;
				check(num);
				if (bingoCheck()) 
					break p;
			}
		}
		
		System.out.println(res);
	}
	
	public static void check(int num) {//해당 위치 체크하기
		int r=0;
		int c=0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(bingo[i][j] == num) {
					r = i;
					c = j;
					check[r][c] = true;
					break;
				}
			}
		}
	}
	
	public static boolean bingoCheck() {
		int total = 0;
		//가로
		for(int i = 0; i<N; i++) {//행체크
			int idx =0;
			int cnt =0;
			while(check[i][idx]) {//idx가 범위내이면서 해당 체크가 트루인 경우
				cnt++;
				idx++;
				if(idx == N)
					break;
			}
			if(cnt == N) {//다 색칠 됐으면 
				total++;
			}
			if(total >= 3) 
				return true;
		}
		
		for(int i = 0; i<N; i++) {//열체크
			int idx =0;
			int cnt =0;
			while(check[idx][i]) {//idx가 범위내이면서 해당 체크가 트루인 경우
				cnt++;
				idx++;
				if(idx == N)
					break;
			}
			if(cnt == N) {//다 색칠 됐으면 
				total++;
			}
			if(total >= 3) 
				return true;
		}
		
		int idx =0;
		int cnt_1 =0;
		int cnt_2 =0;
			
		while(check[idx][idx]) {
			idx++;
			cnt_1++;
			if(cnt_1 == N) {//다 색칠 됐으면 
				total++;
			}
			if(idx == N)
				break;
		}
		if(total >= 3)
			return true;
		
		idx = 0;
		while(check[idx][N - idx - 1]) {
			idx++;
			cnt_2++;
			if(cnt_2 == N) {//다 색칠 됐으면 
				total++;
			}
			if(idx == N)
				break;
		}
						
		if(total >= 3) {
			return true;
		}
		
		return false;//고민
	}
	
}