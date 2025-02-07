import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long sum = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int curr = sc.nextInt();

			while(!stack.isEmpty() && stack.peek() <= curr) {
				stack.pop();
			}
			
			sum += stack.size();
			stack.push(curr);
		}		
		System.out.println(sum);
	}
}