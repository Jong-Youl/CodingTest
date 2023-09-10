import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//바꿀 수
		int B = Integer.parseInt(st.nextToken());//바꿀 진법
		
		String str = "";
		
		while(N  > 0) {
			int tmp  = N % B;
			N = N/B;
			if(tmp < 10)
				str += tmp;
			
			else{
				str += (char)(tmp - 10 + 65);
			}
		}
		
		String res = "";
		
		for(int i = 1; i <= str.length(); i++) {
			res += str.charAt(str.length() - i);
		}
		System.out.println(res);
	}
}