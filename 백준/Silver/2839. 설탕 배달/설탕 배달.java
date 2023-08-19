import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(N%5!=0) {//5의 배수가 될때까지 3을 빼줌
			N -= 3;
			cnt++;
			if(N<0) {
				N = 0;
				cnt = -1;
				break;
			}
		}
		
		cnt += N/5;//5의 배수가 된 N을 5로 나눈 몫을 카운트
		
		System.out.println(cnt);
	}
}