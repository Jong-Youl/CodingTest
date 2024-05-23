import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
		StringBuilder sb = new StringBuilder();
		int targetSize = target.length();

		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= targetSize && stack.peek() == target.charAt(targetSize-1)) {
				StringBuilder tmp = new StringBuilder();
				for(int j = 0; j < targetSize; j++) {
					tmp.append(stack.pop());
				}
				tmp.reverse();
				if(!tmp.toString().equals(target)) {
					for(int k = 0; k < targetSize; k++) {
						stack.push(tmp.charAt(k));
					}
				}
			}
		}
		if (stack.isEmpty()) sb.append("FRULA");
		else {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
		}
		System.out.println(sb);
	}
}