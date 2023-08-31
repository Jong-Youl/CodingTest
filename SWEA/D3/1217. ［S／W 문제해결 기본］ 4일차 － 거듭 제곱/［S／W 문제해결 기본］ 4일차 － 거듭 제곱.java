import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		for(int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int res = sol(N, M);
			
			System.out.println("#"+ tc + " " + res);
		}
	}
	
	public static int sol(int N, int M) {
		if(M == 0) {
			return 1;
		}
		
		if(M >= 2) {
            if(M % 2 == 0)
				return sol(N, M/2) * sol(N, M/2);
           	else
				return sol(N, M/2) * sol(N, M/2+1);
		}
		else {
			 return N;
		}
	}

}