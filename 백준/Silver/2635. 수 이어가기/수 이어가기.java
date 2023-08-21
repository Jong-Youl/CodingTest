import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max_cnt = 0;//N부터 카운트
		int max_i = 0;
		
		for(int i = 1; i<=N; i++) {
			int tmp1 = N;
			int tmp2 = i;
			int cnt = 2;
			while(true) {
				int tmp = tmp2;
				tmp2 = tmp1 - tmp2;
				tmp1 = tmp;
				if(tmp2 < 0) {
					if(max_cnt < cnt) {
						max_i = i;
						max_cnt = cnt;
					}
					break;
				}
				cnt++;
			}
		}
		
		System.out.println(max_cnt);
		int [] res = new int [max_cnt];
		res[0] = N;
		res[1] = max_i;
		
		for(int i = 2; i<max_cnt; i++) {
			res[i] = res[i-2] - res[i-1];
		}
		for(int i = 0; i<max_cnt; i++) {
			System.out.printf(res[i] + " ");
		}
	}
}