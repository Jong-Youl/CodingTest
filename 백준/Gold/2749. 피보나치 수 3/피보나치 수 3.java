import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int m = 1_000_000;
		int p = 15 * 100_000;
		
		n %= p;
		int [] fib = new int [(int)n + 1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fib[i] = (fib[i-1] + fib[i-2]) % m;
		}
		
		System.out.println(fib[(int) n]);
	}

}