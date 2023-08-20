import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int N = Integer.parseInt(br.readLine());
	int [] arr = new int [N+1];
	int [] ord = new int [N+1];
	
	st = new StringTokenizer(br.readLine());
	
	for(int i=1; i<=N; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}//숫자 배열 입력 완료
	
	
	for(int i=1; i<=N; i++) {
		int idx = i - arr[i];
		if(ord[idx] == 0) {//비어있으면 숫자 그대로
			ord[idx] = i;
		}
		else {//있으면
			for(int j = i; j>idx; j--) {
				ord[j] = ord[j-1];//하나씩 밀리기
			}
			ord[idx] = i;
		}
	}
		
	for(int i=1; i<=N; i++) {
		System.out.printf(ord[i]+" ");
	}
}
}