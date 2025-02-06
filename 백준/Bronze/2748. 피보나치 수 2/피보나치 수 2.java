import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long [] fib = new long [91];
		
		fib[1] = 1;
		fib[2] = 1;
		
		for(int i = 3; i <= 90; i++)
			fib[i] = fib[i-1] + fib[i - 2];
		
		System.out.println(fib[n]);
	}
}