import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] fib_z;//0출력 횟수 저장 배열
	public static int[] fib_o;//1출력 횟수 저장 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(br.readLine());
			sb.append(fibonacci_zero(num));
			sb.append(" ");
			sb.append(fibonacci_one(num));
			System.out.println(sb);
		}
	}
	
	public static int fibonacci_zero(int num) {
		fib_z = new int [num+1];
		if (num == 0) {
			return 1;
		}
		
		fib_z[0] = 1;
		fib_z[1] = 0;
		
		for(int i=2; i<=num; i++) {
			fib_z[i] = fib_z[i-1] + fib_z[i-2];	
		}
		
		return fib_z[num];
	}	
	public static int fibonacci_one(int num) {
		fib_o = new int [num+1];
		if (num == 0) {
			return 0;
		}
		fib_o[0] = 0;
		fib_o[1] = 1;
		for(int i=2; i<=num; i++) {
			fib_o[i] = fib_o[i-1] + fib_o[i-2];
			
		}
		return fib_o[num];
	}
}
