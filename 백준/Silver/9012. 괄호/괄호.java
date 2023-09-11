import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static Stack<Character> stack;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
	p:	for(int i = 0; i < N; i++) {
			String str = br.readLine();
			stack = new Stack<>();
			
			for(int j = 0; j < str.length(); j++) { 
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}
				else {
					if(stack.isEmpty()) {						
						System.out.println("NO");
						continue p;
					}
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
				continue p;
			}
			System.out.println("NO");
		}
		

	}

}