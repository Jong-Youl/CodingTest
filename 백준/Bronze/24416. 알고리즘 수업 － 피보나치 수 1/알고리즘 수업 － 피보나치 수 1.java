import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int res1;
	static int res2;
	static int[] fib;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		fib = new int[N+1];
		fib1(N);
		fib2(N);
		
		System.out.println(res1+" "+res2);
	}
	
	public static void fib1(int n) {
		if(n == 1 || n ==2) {
			res1++;
			return;
		}
		else 
			fib1(n-1);
			fib1(n-2);
			return;
	}
	
	public static void fib2(int n) {	
		fib[2] = 1;
		fib[1] = 1;
		
		for(int i=3;i<=n;i++) {
			fib[i] = fib[i-1] + fib[i-2];
			res2++;
		}
		return;
	}

}