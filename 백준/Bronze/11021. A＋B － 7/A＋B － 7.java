import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.printf("Case #%d: %d\n", i, Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
		}
		
	}
}