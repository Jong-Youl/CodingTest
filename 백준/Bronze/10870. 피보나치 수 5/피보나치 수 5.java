import java.util.Scanner;

// 분해합
public class Main {
	static int Fib = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 받는 수
		
		System.out.println(fib(N));

	}

	public static int fib(int num) {
		if (num == 0) {
			return 0;
		} else if (num <= 2) {
			return Fib;
		} else {
			return fib(num - 1) + fib(num - 2);
		}

	}
}