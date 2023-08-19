import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());//케잌 길이
		int N = Integer.parseInt(br.readLine());//방청객 수
		
		boolean [] cake = new  boolean [L+1];//케잌 분배 확인
		int [] expect = new int [N+1];//기대 조각
		int [] real = new int [N+1];//실제 조각
		
		int	max1 = 0;//최대값 찾기1
		int max2 = 0;//최대값 찾기2
		int idx1 = 0;//인덱스 추출1
		int idx2 = 0;//인덱스 추출2
		
		for(int i=1; i<=N;i++) {//i == 사람 번호
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			expect[i] = k-p+1;//기대 조각 수
			
			for(int j = p; j<=k; j++) {
				if(cake[j]==false) {//아무도 케잌을 먹지 않았다면
					cake[j] = true;//바꿔주고
					real[i]++;//실제 조각 많은거에 췤
				}
			}			
		}
		
		for(int i=1; i<=N;i++) {//i == 사람 번호
			if(max1 < expect[i]) {//기대조각이 최대값보다 크면
				max1 = expect[i];//최대값 갱신
				idx1 = i;
			}
			
			if(max2 < real[i]) {
				max2 = real[i];//최대값 갱신
				idx2 = i;
			}
		}
		System.out.println(idx1);
		System.out.println(idx2);
	}
}