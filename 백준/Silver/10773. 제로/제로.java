import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());//K 입력
		
		
		for(int i=0; i<K;i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {// 0이면 마지막 입력값 제거
				stack.pop();
			}
			else {
				stack.push(n);
			}
		}
		
		int size = stack.size();
		int sum = 0;
		
		
		for(int i =0; i<size; i++) {
			sum += stack.pop(); 
		}
		System.out.println(sum);
	}
}