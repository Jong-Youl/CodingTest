import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 100;
		boolean [][] arr = new boolean [N+1][N+1];
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int r = y1; r<y2;r++) {
				for(int c = x1; c<x2;c++) {
					arr[r][c] = true;
				}
			}
		}
		int cnt = 0;
		
		for(int r = 1; r<=N;r++) {
			for(int c = 1; c<=N;c++) {
				if(arr[r][c] == true) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}