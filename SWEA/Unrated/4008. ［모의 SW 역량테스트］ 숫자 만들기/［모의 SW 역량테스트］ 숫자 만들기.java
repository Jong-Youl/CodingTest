import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int min, max, N;
	public static int [] op, num, set_case;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int tc = 1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			op = new int [4];//더하기 빼기 곱하기 나누기 순서
			num = new int [N];
			set_case = new int [N-1];
			//연산자 배열
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			//숫자 배열
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			set(0);
			
			int res = max - min;
			
			System.out.println("#"+ tc + " "+ res);
		}
		
	}
	
	public static void set(int idx) {
		if(idx == N-1) {//연산자 세팅은 인덱스가 N-2까지 있기 때문에 N-1이면 다 채운것으로 간주하고 탈출 
			sum();
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(op[i] == 0)//연산자 없으면
				continue;//다음
			op[i]--;
			set_case[idx] = i;
			set(idx+1);
			op[i]++;//복구, -부터 시작하는 경우를 위해서
		}		
			
	}
		
	public static void sum() {
		int sum = num[0];
		for(int i = 0; i<N-1; i++) {
			if(set_case[i] == 0)//더하기면
				sum += num[i+1];
			else if(set_case[i] == 1)//빼기면
				sum -= num[i+1];
			else if(set_case[i] == 2)//곱하기면
				sum *= num[i+1];
			else//나누기면
				sum /= num[i+1];
		}
		
		max = Math.max(max, sum);
		min = Math.min(min, sum);
	}
	
}