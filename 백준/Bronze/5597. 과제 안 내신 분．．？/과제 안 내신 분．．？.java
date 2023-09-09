import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean [] student = new boolean [31];
		int [] arr = new int [2];
		int idx = 0;
		
		for(int i = 0; i<28; i++) {
			student[Integer.parseInt(br.readLine())] = true; 
		}
		for(int i = 1; i<=30; i++) {
			if(!student[i])
				arr[idx++] = i; 
		}
		Arrays.sort(arr);
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}