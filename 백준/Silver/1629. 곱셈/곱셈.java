import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static long C;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A,B));	
	}
	
	public static long pow(long c, long n) {
		if(n == 1) {//1일때는 그냥 씀
			return c % C;
		}
		
        long tmp = pow(c, n/2);
        
		if(n % 2 == 0) {
			return tmp * tmp % C;
		}
		return (tmp * tmp % C) * c % C;
		
	}
}