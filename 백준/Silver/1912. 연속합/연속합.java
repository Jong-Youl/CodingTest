import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int total = 0;
		
		int[] num = new int[N + 1];
		int[] sum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {// 숫자 입력
			num[i] = Integer.parseInt(st.nextToken());
			sum[i] = num[i];
		}
		 
		for (int i = 1; i <= N; i++) {
			if(total + num[i] >= 0) {//연속합이 max보다 크다면 일단 계속 더함
				total +=num[i];
				max = Math.max(max, total);				
			}
			else {//아니면 다음 수로 넘어감
				total +=num[i];
				max = Math.max(max, total);
				total = 0;
				continue;
			}
		}
		System.out.println(max);
	}

}