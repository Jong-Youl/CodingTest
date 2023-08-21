import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int [][]arr = new int [R+1][C+1];
		int [] dr = {1, 0, -1, 0};//하 우 상 좌
		int [] dc = {0, 1, 0, -1};//하 우 상 좌
		
		int K = Integer.parseInt(br.readLine());
		int cnt = 1;//관객 대기번호
		int dir = 0;
		
		int r=1;
		int c=1;
		
		while(true) {
			if(cnt == K) {
				
				System.out.println(c+ " " + r);
				break;
			}
			else if(cnt > R*C) {
				System.out.println(0);
				break;
			}
			
			arr[r][c] = cnt++;
			
			int new_r = r+dr[dir];
			int new_c = c+dc[dir];
			if(new_r<1 || new_r>R || new_c<1 || new_c>C || arr[new_r][new_c] != 0) {//범위 체크
				dir = (dir+1) % 4;
				
				new_r = r+dr[dir];
				new_c = c+dc[dir];
			}
			r = new_r;
			c = new_c;
		}
		
	}
}