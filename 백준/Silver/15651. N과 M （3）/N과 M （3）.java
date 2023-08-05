import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Main {
	static int N = 0;
	static int M = 0;
	static int[] arr = new int[9];// 최대 8이기 떄문에
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		backtrack(0);
        bw.flush();
        bw.close();

	}
	
	public static void backtrack(int k) throws IOException {
		if(k == M) {
			for(int i=0; i<M; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i = 1; i<=N; i++) {
				arr[k] = i;
				backtrack(k+1);
		}
		
	}
		
}