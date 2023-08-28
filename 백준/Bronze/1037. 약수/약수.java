import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = Integer.parseInt(br.readLine());
		int [] arr = new int [cnt];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<cnt;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = arr[0];
		int max = arr[cnt-1];
		
		int res = min * max;
		
		System.out.println(res);
	}
}