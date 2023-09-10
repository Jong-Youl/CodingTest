import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		
		int num1 = 1;
		int num2 = 1;
		int cnt = 1;
		int dir = 0;
		
		while(idx < N) {
			if(dir == 0) {
				if(num2 == cnt) {
					cnt++;
					num2++;
					dir = 1;
				}
				else {
					num2++;
					num1--;
				}
				idx++;
				continue;
			} 
						
			if(dir == 1) {
				if( num1 == cnt) {
					cnt++;
					num1++;
					dir = 0;
				}
				else {
					num1++;
					num2--;
				}
				idx++;
				continue;
			} 
		}
		
		System.out.println(num1 + "/" + num2);
	}
}