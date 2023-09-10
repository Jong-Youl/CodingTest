import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		int res = 0;
		
		for(int i = 0; i < N.length(); i++) {
			int idx = N.length() - i - 1;
			if(Character.isDigit(N.charAt(i))){//해당 칸이 숫자라면
				res += (N.charAt(i) - '0') * Math.pow(B, idx);  
			}
			else {
				res += (N.charAt(i) - 'A' + 10) * Math.pow(B, idx);
			}
		}
		
		System.out.println(res);
	}
	
}