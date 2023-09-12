import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//버블 소트 연습
public class Main {
	
	public static StringTokenizer st;
	public static int [] performace;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		performace = new int [N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			performace[i] = Integer.parseInt(st.nextToken());
		}
		
		bubble_sort(performace);
		
		sb.append(performace[K-1]);
		
		System.out.println(sb);
		
	}
	public static void bubble_sort(int [] arr) {// DESC 버전
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr.length-i; j++) {
				if(arr[j-1] < arr[j]) {//내림차순이 아니면
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
}