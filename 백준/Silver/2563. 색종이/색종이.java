import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int N = Integer.parseInt(br.readLine());//색종이 개수
	
	boolean [][] paper = new boolean [101][101];//전체 칸 수
	
	int res = 0;
	
	for(int i=0; i<N;i++) {
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		for(int j = x; j<x+10; j++) {
			for(int k = y; k<y+10; k++) {
				paper[k][j] = true;
			}
		}
	}
	
	for(int r = 0; r<101; r++) {
		for(int c = 0; c<101; c++) {
			if(paper[r][c] == true) {
				res++;
			}
		}
	}
	
	System.out.println(res);
}
}