import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//최대 50만
		//3번 돌리기 때문에 존나 높아 질 수 있음
		long N = Integer.parseInt(br.readLine());
		
		
		long cnt = N * (N-1) * (N-2) / 6;
		
		cnt = cnt <=  0 ? 0 : cnt;
		System.out.println(cnt);
		System.out.println(3);
	}
	
}