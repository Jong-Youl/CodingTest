import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder(); 
		
		Stack<Integer> stack = new Stack<>();
		

		for (int i = 0; i < n; i++) {

			int k = sc.nextInt();

			if (k == 1) {

				int a = sc.nextInt();

				stack.push(a);

			}

			else if (k == 2) {

				if (!stack.isEmpty()) {
					
					sb.append(stack.pop()).append("\n");
//					System.out.println(stack.pop());
				}

				else {

					sb.append(-1).append("\n");
//					System.out.println(-1);

				}
			}

			else if (k == 3) {

//				System.out.println(stack.size());
				sb.append(stack.size()).append("\n");
			}

			else if (k == 4) {

				if (stack.isEmpty()) {

//					System.out.println(1);
					sb.append(1).append("\n");
				}

				else {

//					System.out.println(0);
					sb.append(0).append("\n");

	
				}

			}

			else if (k == 5) {

				if (stack.isEmpty()) {

//					System.out.println(-1);
					sb.append(-1).append("\n");

				}

				else {
					
					
					sb.append(stack.peek()).append("\n");
//					System.out.println(stack.peek());
//					stack.peek();
				}
			}
			
			
		}
		
		System.out.println(sb);
	}
}
