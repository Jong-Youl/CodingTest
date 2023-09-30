import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int max, min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());

		int [][] scoreBoard = new int[N][3];		
		int [][] dpMax = new int[N][3];
		int [][] dpMin = new int[N][3];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			scoreBoard[i][0] = Integer.parseInt(st.nextToken());
			scoreBoard[i][1] = Integer.parseInt(st.nextToken());
			scoreBoard[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < 3; i++) {
			dpMax[0][i] = dpMin[0][i] = scoreBoard[0][i];
		}
		
		if(N > 1) {
			for(int i = 1; i < N; i++) {
				dpMax[i][0] = scoreBoard[i][0] + Math.max(dpMax[i-1][0], dpMax[i-1][1]);
				dpMin[i][0] = scoreBoard[i][0] + Math.min(dpMin[i-1][0], dpMin[i-1][1]);
				
				dpMax[i][1] = scoreBoard[i][1] + Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1])
														, Math.max(dpMax[i-1][1], dpMax[i-1][2]));				
				dpMin[i][1] = scoreBoard[i][1] + Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1])
														, Math.min(dpMin[i-1][1], dpMin[i-1][2]));
				
				dpMax[i][2] = scoreBoard[i][2] + Math.max(dpMax[i-1][1], dpMax[i-1][2]);
				dpMin[i][2] = scoreBoard[i][2] + Math.min(dpMin[i-1][1], dpMin[i-1][2]);			
				}
		}
		
		for(int i = 0; i < 3; i++) {
			max = Math.max(max, dpMax[N-1][i]);
			min = Math.min(min, dpMin[N-1][i]);
		}
		
		
		sb.append(max).append(" ").append(min);
		System.out.println(sb);
	}
}