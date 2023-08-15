import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int res = 0;
		for(int i=0; i<N;i++) {
			res += (s.charAt(i)-'0');
		}
		
		System.out.println(res);
		}
}