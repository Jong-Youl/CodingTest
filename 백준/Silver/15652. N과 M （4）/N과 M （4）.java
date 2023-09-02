import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [M];
		
		reclusive(0, 1, arr);
		
	}
	
	public static void reclusive(int depth, int value, int [] arr) {
		//탈출
		if(depth == M) {	
			for(int i = 0; i < M; i++) {
				System.out.printf(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		//기저
		for(int i = value; i <=N; i++) {
			arr[depth] = i;
			reclusive(depth+1, i, arr);
		}
		
	}
}