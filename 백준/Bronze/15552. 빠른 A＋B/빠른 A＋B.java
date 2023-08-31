import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			sb.append(tmp1 + tmp2+"\n");
		}
		System.out.println(sb);
	}
}