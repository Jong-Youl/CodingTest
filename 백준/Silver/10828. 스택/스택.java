import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String str = sb.toString();

		int n = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();

		for (int tc = 1; tc <= n; tc++) {

			String a = br.readLine();
			String[] arr = a.split(" ");

			String f1;
			int f2= 0;

			if (arr.length == 2) {

				f1 = arr[0];
				f2 = Integer.parseInt(arr[1]);

			}

			if (arr[0].equals("push")) {

				stack.push(f2);
			}

			else if (arr[0].equals("pop")) {

				if (stack.isEmpty()) {

					sb.append(-1).append("\n");
				}

				else {

					sb.append(stack.pop()).append("\n");

				}

			}

			else if (arr[0].equals("size")) {
				sb.append(stack.size()).append("\n");
			}

			else if (arr[0].equals("empty")) {
				if (stack.isEmpty()) {

					sb.append(1).append("\n");
				}

				else {

					sb.append(0).append("\n");

				}
			}

			else if (arr[0].equals("top")) {
				if (stack.isEmpty()) {

					sb.append(-1).append("\n");
				}

				else {

					sb.append(stack.peek()).append("\n");

				}
			}
			
		}
		System.out.println(sb);
	}
}
