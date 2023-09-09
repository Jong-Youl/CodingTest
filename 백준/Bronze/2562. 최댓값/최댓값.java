import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		
		for(int i = 1; i<10; i++) {
			int tmp = Integer.parseInt(br.readLine()); 
			if(max < tmp){
				max = tmp;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}