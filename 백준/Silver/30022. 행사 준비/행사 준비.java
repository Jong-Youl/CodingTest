import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int [N][3];
		
		long res = 0;
				
		for(int i = 0; i <N; i++) {
			//a와 b를 카운트로 받으면서
			//줄여가보자
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr [i][0] = a;
			arr [i][1] = b;
			arr [i][2] = Math.abs(a-b);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[2] - o1[2];
			}
		});
		
		for(int i = 0; i < N ; i++) {
			if(A == 0) {//A를 다 샀으면
				res += arr[i][1];
				continue;
			}
			if(B == 0) {//B를 다 샀으면
				res += arr[i][0];
				continue;
			}
			if(arr[i][0] > arr[i][1]) {
				B--;
				res += arr[i][1]; 
			}
			else{
				A--;
				res += arr[i][0];
			}
		}
		System.out.println(res);
	}
}